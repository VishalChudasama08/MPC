import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Swing_019_ProgressBar {
    JFrame frame;
    JProgressBar progressBar, progressBar1, progressBar2;
    int i = 0, number = 0;
    Swing_019_ProgressBar(){
        frame = new JFrame("Swing ProgressBar Example");
        frame.setSize(500, 600);
        frame.setLayout(null);

        // used to display the progress of the task. It inherits JComponent class.
        progressBarExample(); // javatpoint

        progressBarExample_All(); // chatGPT
        progressBarExample_Advance(); // chatGPT

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void progressBarExample(){
        progressBar = new JProgressBar(0,2000);
        progressBar.setBounds(10, 10, 300, 30);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        frame.add(progressBar);
    }
    public void iterate(){
        while (i <= 2000){
            progressBar.setValue(i);
            i=i+20;
            try{
                Thread.sleep(150); // 150 milliseconds wait than continue...
                // pauses the execution for 150 milliseconds in each iteration to simulate a time-consuming task.
            } catch (Exception ignore){

            }
        }
        System.out.println("Progress Bar 1 complete");
    }


    void progressBarExample_All(){
        progressBar1 = new JProgressBar();
        progressBar1.setBounds(10, 100, 300, 30);
        frame.add(progressBar1);

        // Set the minimum and maximum values for the progress
        progressBar1.setMinimum(0);  // Default is 0
        progressBar1.setMaximum(100);  // Default is 100

        // Set initial value (current progress)
        progressBar1.setValue(0);  // Progress set to 0

        // Enable or disable string representation of progress
        progressBar1.setStringPainted(true);  // Show % progress

        // Change the orientation (horizontal/vertical)
        // progressBar1.setOrientation(JProgressBar.VERTICAL);  // For vertical orientation

        // Change the background and foreground colors
        progressBar1.setForeground(Color.BLUE); // Change progress bar color
        progressBar1.setBackground(Color.LIGHT_GRAY); // Change background color

        // Indeterminate progress bar (used when progress is unknown)
        // progressBar1.setIndeterminate(true);  // Shows continuous movement

        // Simulate progress in a background thread
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    // Simulate task duration
                    Thread.sleep(200);

                    // Update the progress value
                    progressBar1.setValue(i);

                    // Optionally set the string text explicitly
                    // progressBar1.setString(i + "% Completed");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Progress bar 2 complete");
        }).start();
    }

    void progressBarExample_Advance(){
        progressBar2 = new JProgressBar(0, 100);
        progressBar2.setBounds(10, 200, 300, 30);
        progressBar2.setStringPainted(true); // Show the percentage (%) on the progress bar

        frame.add(progressBar2);
        System.out.println("progress start");
        // Create a SwingWorker that performs the task in the background
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception { // This method runs in the background thread
                // Simulate progress by incrementing from 0 to 100
                for (int progress = 0; progress <= 100; progress++) {
                    Thread.sleep(250);  // Pause for 100ms to simulate a long-running task
                    publish(progress);  // Send the current progress to the process() method
                }
                return null; // Return null when the background task is complete
            }

            // This method runs on the Event Dispatch Thread (EDT) and updates the UI
            @Override
            protected void process(List<Integer> chunks) {
                // Iterate over the chunks of progress values received
                for (int progress : chunks) {
                    progressBar2.setValue(progress);  // Update the progress bar's value
                }
            }

            // This method runs when the background task is complete
            @Override
            protected void done() {
                System.out.println("Progress bar 3 complete");  // Print a message when done
            }
        };
        worker.execute();  // Start the SwingWorker, which will run in the background
        System.out.println("I am last console. Yes this is Asynchronous-Like Behavior, code run continuously not waiting. ");

        /*
         * SwingWorker: A background worker thread that performs a task without freezing the UI.
            doInBackground(): This method runs in the background and simulates progress by incrementing the progress from 0 to 100.
            Thread.sleep(100): Pauses the execution for 100 milliseconds to simulate a time-consuming task.
            publish(progress): Sends the progress value to the process() method.
            process(): This method runs on the Event Dispatch Thread (EDT) and updates the JProgressBar with the current progress value.
            done(): This method is called after the background task is complete, allowing for final cleanup or notification.

         * Asynchronous-Like Behavior
            Using SwingWorker enables the background processing of tasks without freezing the UI, similar to JavaScript's asynchronous functions.
         */
    }
    public static void main(String[] args) {
        Swing_019_ProgressBar progressObj = new Swing_019_ProgressBar();
        progressObj.iterate();
    }
}
