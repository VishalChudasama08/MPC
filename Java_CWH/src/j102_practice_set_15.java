import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class j102_practice_set_15 {
    public static void main(String[] args) {
        // Q-1
        ArrayList arr = new ArrayList();
        arr.add("Student 1");
        arr.add("Student 2");
        arr.add("Student 3");
        arr.add("Student 4");
        arr.add("Student 5");
        arr.add("Student 6");
        arr.add("Student 7");
        arr.add("Student 8");
        arr.add("Student 9");
        arr.add("Student 10");
        for (Object o: arr) {
            System.out.println(o);
        }

        // Q-2
        Date d = new Date();
        System.out.println(d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds());

        // Q-3
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));

        // Q-4
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("H:m:s || dd/MM/yyyy");

        String s = dt.format(df);
        System.out.println(s);

        // Q-5
        HashSet<Integer> hs = new HashSet<>();
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(8);
        hs.add(5);
        hs.add(8);
        System.out.println(hs); // 8 add only 1 time
    }
}
