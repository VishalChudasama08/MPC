import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Swing_042_Digital_Clock implements Runnable {
    JFrame frame;
    Thread t = null;
    int hours=0, minutes=0, seconds=0;
    String timeString = "";
    JButton button;

    Swing_042_Digital_Clock(){
        frame = new JFrame("Swing Digital Clock");
        frame.setLayout(null);
        frame.setSize(400,300);

        t = new Thread(this);
        t.start();

        button = new JButton();
        button.setBounds(100,100,100,40);
        button.setMargin(new Insets(0,0,0,0));
        button.setEnabled(false);

        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        try{
            while (true) {
                Calendar calendar = Calendar.getInstance();
                hours = calendar.get(Calendar.HOUR_OF_DAY);

                if(hours > 12) hours -= 12;

                minutes = calendar.get(Calendar.MINUTE);
                seconds = calendar.get(Calendar.SECOND);

                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                Date date = calendar.getTime();
                timeString = dateFormat.format(date);

                button.setText(timeString);

                t.sleep(1000);
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        new Swing_042_Digital_Clock();
    }
}
