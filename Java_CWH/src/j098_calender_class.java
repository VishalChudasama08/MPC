import java.util.Calendar;
import java.util.TimeZone;

public class j098_calender_class {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance(); // write this to use calendar class
        // for more:- https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Calendar.html
        System.out.println(c.getCalendarType());
        System.out.println(c.getTimeZone());

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Singapore"));
        System.out.println(cal.getCalendarType());
        System.out.println(cal.getTimeZone());
        System.out.println(cal.getTimeZone().getID());


        System.out.println(c.getTime());
        System.out.println(c.getFirstDayOfWeek());
        System.out.println(c.getActualMaximum(1));

        System.out.println(c);
        System.out.println("ALL_STYLES : " + c.ALL_STYLES);
        System.out.println("AM : " + c.AM);
        System.out.println("AM_PM : " + c.AM_PM);
        System.out.println("SECOND : " + c.SECOND);
        System.out.println("MINUTE : " + c.MINUTE);
        System.out.println("HOUR : " + c.HOUR);
//        System.out.println(c.HOUR + ":" + c.MINUTE + ":" + c.SECOND + " " + ((c.PM==0)?"am":"pm"));
        System.out.println("DATE : " + c.DATE);
        System.out.println("MONTH : " + c.MONTH);
        System.out.println("YEAR : " + c.YEAR);
        System.out.println();

        System.out.println("DAY_OF_WEEK_IN_MONTH : " + c.DAY_OF_WEEK_IN_MONTH);
        System.out.println("DAY_OF_WEEK : " + c.DAY_OF_WEEK);
        System.out.println("DAY_OF_MONTH : " + c.DAY_OF_MONTH);
        System.out.println("DAY_OF_YEAR : " + c.DAY_OF_YEAR);
        System.out.println("WEEK_OF_MONTH : " + c.WEEK_OF_MONTH);
        System.out.println("WEEK_OF_YEAR : " + c.WEEK_OF_YEAR);

        System.out.println();
        System.out.println("JANUARY : " + c.JANUARY);
        System.out.println("FEBRUARY : " + c.FEBRUARY);
        System.out.println("MARCH : " + c.MARCH);
        System.out.println("APRIL : " + c.APRIL);
        System.out.println("MAY : " + c.MAY);
        System.out.println("JUNE : " + c.JUNE);
        System.out.println("JULY : " + c.JULY);
        System.out.println("AUGUST : " + c.AUGUST);
        System.out.println("SEPTEMBER : " + c.SEPTEMBER);
        System.out.println("OCTOBER : " + c.OCTOBER);
        System.out.println("NOVEMBER : " + c.NOVEMBER);
        System.out.println("DECEMBER : " + c.DECEMBER);
        System.out.println();

        System.out.println("SUNDAY : " + c.SUNDAY);
        System.out.println("MONDAY : " + c.MONDAY);
        System.out.println("TUESDAY : " + c.TUESDAY);
        System.out.println("WEDNESDAY : " + c.WEDNESDAY);
        System.out.println("THURSDAY : " + c.THURSDAY);
        System.out.println("FRIDAY : " + c.FRIDAY);
        System.out.println("SATURDAY : " + c.SATURDAY);
    }
}