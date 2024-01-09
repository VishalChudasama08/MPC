import java.util.Calendar;
import java.util.TimeZone;

public class j098_calender_class {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance(); // write this to use calendar class
        // for more:-
        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Calendar.html
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
        System.out.println("ALL_STYLES : " + c.get(Calendar.ALL_STYLES));
        System.out.println("AM : " + c.get(Calendar.AM));
        System.out.println("AM_PM : " + c.get(Calendar.AM_PM));
        System.out.println("SECOND : " + c.get(Calendar.SECOND));
        System.out.println("MINUTE : " + c.get(Calendar.MINUTE));
        System.out.println("HOUR : " + c.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY : " + c.get(Calendar.HOUR_OF_DAY));
        System.out.println(c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + " " + ((c.get(Calendar.AM_PM) == 1) ? "pm" : "am"));
        System.out.println("DATE : " + c.get(Calendar.DATE));
        System.out.println("MONTH : " + c.get(Calendar.MONTH));
        System.out.println("YEAR : " + c.get(Calendar.YEAR));
        System.out.println();

        System.out.println("DAY_OF_WEEK_IN_MONTH : " + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("DAY_OF_WEEK : " + c.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_MONTH : " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR : " + c.get(Calendar.DAY_OF_YEAR));
        System.out.println("WEEK_OF_MONTH : " + c.get(Calendar.WEEK_OF_MONTH));
        System.out.println("WEEK_OF_YEAR : " + c.get(Calendar.WEEK_OF_YEAR));

        System.out.println();
        System.out.println("JANUARY : " + c.get(Calendar.JANUARY));
        System.out.println("FEBRUARY : " + c.get(Calendar.FEBRUARY));
        System.out.println("MARCH : " + c.get(Calendar.MARCH));
        System.out.println("APRIL : " + c.get(Calendar.APRIL));
        System.out.println("MAY : " + c.get(Calendar.MAY));
        System.out.println("JUNE : " + c.get(Calendar.JUNE));
        System.out.println("JULY : " + c.get(Calendar.JULY));
        System.out.println("AUGUST : " + c.get(Calendar.AUGUST));
        System.out.println("SEPTEMBER : " + c.get(Calendar.SEPTEMBER));
        System.out.println("OCTOBER : " + c.get(Calendar.OCTOBER));
        System.out.println("NOVEMBER : " + c.get(Calendar.NOVEMBER));
        System.out.println("DECEMBER : " + c.get(Calendar.DECEMBER));
        System.out.println();

        System.out.println("SUNDAY : " + c.get(Calendar.SUNDAY));
        System.out.println("MONDAY : " + c.get(Calendar.MONDAY));
        System.out.println("TUESDAY : " + c.get(Calendar.TUESDAY));
        System.out.println("WEDNESDAY : " + c.get(Calendar.WEDNESDAY));
        System.out.println("THURSDAY : " + c.get(Calendar.THURSDAY));
        System.out.println("FRIDAY : " + c.get(Calendar.FRIDAY));
        System.out.println("SATURDAY : " + c.get(Calendar.SATURDAY));
    }
}