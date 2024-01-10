import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class j100_time_and_date {
    public static void main(String[] args) {
        // more information of LocalTime: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalTime.html
        // more information of LocalDate: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDate.html

        LocalDate d = LocalDate.now();
        System.out.println(d);
        // directly use .now() method to get Date

        LocalTime t = LocalTime.now();
        System.out.println(t);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
    }
}
