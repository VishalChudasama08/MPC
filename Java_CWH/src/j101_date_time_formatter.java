import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class j101_date_time_formatter {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        // for more information:
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("dd/MM/yyyy || E H:m:s a"); // create your own pattern
        DateTimeFormatter df2 = DateTimeFormatter.ISO_LOCAL_DATE;

        String myDate1 = dt.format(df1); // use DateTimeFormatter in LocalDateTime
        System.out.println(myDate1);

        String myDate2 = dt.format(df2);
        System.out.println(myDate2);
    }
}
