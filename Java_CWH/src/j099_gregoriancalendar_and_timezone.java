import java.util.GregorianCalendar;
import java.util.TimeZone;

public class j099_gregoriancalendar_and_timezone {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        // form more information:- https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/GregorianCalendar.html
        System.out.println(gc.isLeapYear(2024));
        // you perform all calendar methods


        //Time Zone
        for (int i = 0; i < TimeZone.getAvailableIDs().length; i++) {
            System.out.print(TimeZone.getAvailableIDs()[i]); // print all available time zone id
            System.out.print(", ");
            if(i%10 == 0){
                if(i == 0){
                    continue;
                }
                System.out.println();
            }
        }
    }
}
