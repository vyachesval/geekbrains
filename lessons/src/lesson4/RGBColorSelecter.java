package lesson4;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class RGBColorSelecter extends JFrame {
    public RGBColorSelecter() {
        setTitle("RGBColorSelecter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 400);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        add(panel);

        JSlider sliderR= new JSlider(SwingConstants.HORIZONTAL, 0,255, 50);
        sliderR.setMajorTickSpacing(20);
        sliderR.setMinorTickSpacing(5);
        sliderR.setPaintLabels(true);
        sliderR.setPaintTicks(true);

        JSlider sliderG= new JSlider(SwingConstants.HORIZONTAL, 0,255, 50);
        sliderG.setMajorTickSpacing(20);
        sliderG.setMinorTickSpacing(5);
        sliderG.setPaintLabels(true);
        sliderG.setPaintTicks(true);

        JSlider sliderB= new JSlider(SwingConstants.HORIZONTAL, 0,255, 50);
        sliderB.setMajorTickSpacing(20);
        sliderB.setMinorTickSpacing(5);
        sliderB.setPaintLabels(true);
        sliderB.setPaintTicks(true);

        ChangeListener changeListener = e -> {
            panel.setBackground(new Color(
                    sliderR.getValue(),
                    sliderG.getValue(),
                    sliderB.getValue()));
        };


        sliderR.addChangeListener(changeListener);
        sliderG.addChangeListener(changeListener);
        sliderB.addChangeListener(changeListener);

        add(sliderR);
        add(sliderG);
        add(sliderB);
        setVisible(true);
    }
}
