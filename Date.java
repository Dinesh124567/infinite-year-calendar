import java.util.Scanner.*;

public class Date{
    public static void main(String a[]) {
        Date chinu=new Date(12, 1,2000);
        StringBuilder s=new StringBuilder("12012000");
        Date d=new Date("mmddyyyy",s);
        d.showMonth();
        chinu.showMonth();
        (new Date(26,7,2019)).showMonth();
        //System.out.println("day for date is"+chinu.getDefaultDateDay()+" "+(new Date(13,7,2019)).getDefaultDateDay());
    }

    private final int dat;
    private final int month;
    private final int year;
    private int day;
    private int kday;
    private Date kyear;


    public Date(int dd, int mm, int yyyy){
        if(dd<32&& dd>0)dat=dd; else{dat=1;}
        if(mm<13&& mm>0)month=mm; else {month=1;}
        if(yyyy>0) year=yyyy; else{ year=0;}
      
    }

    public Date(String format, StringBuilder Date){
        if(format.contains("dd")&&format.contains("mm")&&format.contains("yyyy")){
            int d=format.indexOf("dd");
            int m=format.indexOf("mm");
            int y=format.indexOf("yyyy");
            dat=Integer.parseInt(Date.substring(d,d+2));
            month=Integer.parseInt(Date.substring(m,m+2));
            year=Integer.parseInt(Date.substring(y,y+2));
        }
        else{dat=1; month=1; year=1;}
    }



    public void showMonth(){
        System.out.println("year :"+year()+" month: "+month());
        for(int i=0; i<=6; i++){
            System.out.print(getWeekdy(i)+" ");
        }
        System.out.println();int c=0;
        int a=-(new Date(1,Month(), year())).getDefaultDateDayint()+1;
        int co=0;
        for(int i=a; i<=monthhasdays(); i++)
           { co++; if(i<=0) { System.out.print(" \t");}
             else{c++; if(c==dat)System.out.print(c+"<-\t"); else System.out.print(c+" \t");
             if(co%7==0) System.out.println();
              }}
        System.out.println();      
    }

    public String month(){
        switch(month){
            case 1: return "january"; 
            case 2: return "febraury"; 
            case 3: return "march";
            case 4: return "aprail";
            case 5: return "may";
            case 6: return "june"; 
            case 7: return "july";
            case 8: return "august"; 
            case 9: return "september"; 
            case 10: return "october"; 
            case 11: return "november"; 
            case 12: return "december"; 
           
            default: return "Error";
        }
    }

    public boolean isLeapyear(){
        if(year%4==0) return true;
        return false;
    }

    public int monthhasdays(){
        switch(month){
            case 1: return 31;
            case 3: return 31;
            case 5: return 31;
            case 7: return 31;
            case 8: return 31;
            case 10: return 31;
            case 12: return 31;    
            case 2: if(isLeapyear()) return 29; else return 28;
            case 4: return 30;
            case 6: return 30;
            case 9: return 30;
            case 11: return 30;
            default: return 0;
        }
    }

    public int Month(){
        return month;
    }
    public int date(){
        return dat;
    }
    public int year(){
        return year;
    }

    public void setDateDay(int Day, Date dt){
        kday=Day;
        kyear=dt;
    }
    public void setDateDay(String Day, Date dt){
        if(Day.contains("sun")) kday=0;
        else if(Day.contains("mon")) kday=1;
        else if(Day.contains("tue")) kday=2;
        else if(Day.contains("wed")) kday=3;
        else if(Day.contains("thu")) kday=4;
        else if(Day.contains("fri")) kday=5;
        else if(Day.contains("sat")) kday=6;
        else kday=0;
        kyear=dt;

    }

    public void setDefaultDateDay(){
        kday=6;
        kyear=new Date(01,01,2000);
    }

    public int getDefaultDateDayint(){
        setDefaultDateDay();
        int jan1=caljan1(kyear.date(),kyear.Month(),kday, kyear.isLeapyear());
        int j1=calYeartyp(kyear.year(), jan1, year);
        int []y={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(isLeapyear()) y[2]=29;
        int sum=0;
        for(int i=0; i<=month-1; i++) sum+=y[i];
        day=((sum+dat)%7+j1)%7-1;
        if(day<0) return 7+day;
        return day;     
    }
    public String getDefaultDateDaystr(){
        int gt=getDefaultDateDayint();
        return getWeekdy(gt);
       
    }
    private String getWeekdy(int wek){
        switch(wek){
            case 0: return "sunday";
            case 1: return "monday";
            case 2: return "tuesday";
            case 3: return "wednesday";
            case 4: return "thursday";
            case 5: return "friday";
            case 6: return "saturday";
            default: return "error";
        }
    }
    public int getDateDayint(){
        int jan1=caljan1(kyear.date(),kyear.Month(),kday, kyear.isLeapyear());
        int j1=calYeartyp(kyear.year(), jan1, year);
        int []y={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(isLeapyear()) y[2]=29;
        int sum=0;
        for(int i=0; i<=month-1; i++) sum+=y[i];
        day=((sum+dat)%7+j1)%7-1;
        if(day<0) return 7+day;
        return day;
    }
    public String getDateDayStr(){
        int gt=getDateDayint();
        return getWeekdy(gt);
    }
    
    
    private int calYeartyp(int kyear, int jan1, int year){
        int c=0,l=0;int j1;
        if(kyear>year) {
            for(int i=kyear-1; i>=year; i--){
                 if(i%4==0 ) l++; c++;  } 
                 j1=(jan1-((l+c)%7))%7;
                 if(j1<0) j1=7+j1; }
        else{
            for(int i=kyear; i<year; i++){
                 if(i%4==0) l++; c++;}
                  j1=((l+c)%7+jan1)%7;
            }        
         
        return j1;
    }
    private int caljan1(int dats, int months, int days, boolean Leapyear){
        int []y={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(Leapyear) y[2]=29;
        int sum=0,nod=0;
        for(int i=0; i<=months-1; i++) sum+=y[i];
        nod=sum+dats;
        int dayy=(days-(nod%7)+1)%7;
        if(dayy<0) return 7+dayy;
        return dayy;
    }

}