import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Swing_023_Slider {
    JFrame frame;
    Swing_023_Slider(){
        frame = new JFrame("Swing Slider Example");
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());

        sliderExample(); // javatpoint
        sliderExamplePaintingTicks(); // javatpoint

        sliderExample2(); // chatGPT

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void sliderExample(){
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0,50,25);
        JPanel panel = new JPanel();
        panel.add(slider);
        frame.add(panel);
    }

    void sliderExamplePaintingTicks(){
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
        slider.setMinorTickSpacing(2);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JPanel panel = new JPanel();

        panel.add(slider);
        frame.add(panel);
    }

    void sliderExample2(){
        JLabel valueLabel = new JLabel("Value: 0");
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);

        // Sets the spacing between minor and major ticks.
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(20);

        // Enables painting ticks and labels on the slider.
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // Adding change listener to slider
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue(); // Retrieves the current value of the slider.
                valueLabel.setText("Value: " + value);
                System.out.println("Adjusted to: " + value);
            }
        });

        frame.add(valueLabel);
        frame.add(slider);
    }


    public static void main(String[] args) {
        new Swing_023_Slider();
    }
}
