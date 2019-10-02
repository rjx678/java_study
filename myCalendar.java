import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class myCalendar {
    public static void chineseCalender(String str) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(str);
        Calendar c1 = new GregorianCalendar();
        c1.setTime(d);
        int day=c1.get(Calendar.DAY_OF_MONTH);
        c1.set(Calendar.DAY_OF_MONTH, 1);//设置日历开始日期，为一号
//        System.out.println(c1.get(Calendar.DAY_OF_WEEK));
        System.out.println("一\t" + "二\t" + "三\t" + "四\t" + "五\t" + "六\t" + "日");

        if(c1.get(Calendar.DAY_OF_WEEK)==1){//如果第一天是星期日
            System.out.print("\t\t\t\t\t\t");
        }
        //第一行进行平移
        for (int i = 0; i < c1.get(Calendar.DAY_OF_WEEK) - 2; i++) {
            System.out.print("\t");
        }
        int days1 = c1.getActualMaximum(Calendar.DATE);

        for (int i = 1; i <= days1; i++) {
            if(day==c1.get(Calendar.DAY_OF_MONTH)){
                System.out.print(c1.get(Calendar.DAY_OF_MONTH) + "*\t");
            }else{
            System.out.print(c1.get(Calendar.DAY_OF_MONTH) + "\t");}
            if (c1.get(Calendar.DAY_OF_WEEK) == 1) {
                System.out.println();
            }
            c1.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

    public static void englishCalender(String str) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(str);
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        int day=c.get(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置日历开始日期，为一号
//        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println("\n日\t" + "一\t" + "二\t" + "三\t" + "四\t" + "五\t" + "六\t");

        for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 1; i++) {
            System.out.print("\t");
        }
        int days = c.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= days; i++) {
            if(day==c.get(Calendar.DAY_OF_MONTH)){
                System.out.print(c.get(Calendar.DAY_OF_MONTH) + "*\t");
            }else{
            System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");}
            if (c.get(Calendar.DAY_OF_WEEK) == 7) {
                System.out.println();
            }
            c.add(Calendar.DAY_OF_MONTH, 1);
        }

    }

    public static void main(String[] args) throws ParseException {

        System.out.println("请输入一个日期(格式为2019-09-03):");
        Scanner scanner=new Scanner(System.in);
        String str =scanner.nextLine();
        System.out.println("\n中国日期格式");
        chineseCalender(str);
        System.out.println("\n##########################");
        System.out.println("\n外国日期格式");
        englishCalender(str);
    }
}