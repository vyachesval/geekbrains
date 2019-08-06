package lesson4;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class MyWindow extends JFrame {
    int style = 0;
    int size = 30;
    String fontName = "Arial";


    public MyWindow() {
        setTitle("Lesson4");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 400);

//        add(new JButton("Center"),BorderLayout.CENTER);
//        add(new JButton("NORTH"),BorderLayout.NORTH);
//        add(new JButton("SOUTH"),BorderLayout.SOUTH);
//        add(new JButton("WEST"),BorderLayout.WEST);
//        add(new JButton("EAST"),BorderLayout.EAST);

//        setLayout(new FlowLayout());
//        setLayout(new GridLayout(3,3));

//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//
//        for (int i = 0; i < 8; i++) {
//            panel.add(new JButton("btn #"+i));
//        }
//        add(panel);

//        setLayout(new FlowLayout());
//        JButton btn1= new JButton("btn1");
//        JButton btn2= new JButton(new ImageIcon("D:\\java\\java_2_25072019\\src\\img\\hashtag.png"));
//        JButton btn3= new JButton("btn3", new ImageIcon("D:\\java\\java_2_25072019\\src\\img\\exit.png"));
//
//        add(btn1);
//        add(btn2);
//        add(btn3);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        JTextField textField = new JTextField();
        panel1.add(textField);
        JButton btnSend = new JButton("send");
        panel1.add(btnSend);
        add(panel1, BorderLayout.SOUTH);


        JTextArea textArea = new JTextArea();
        JScrollPane jsp = new JScrollPane(textArea);
        textArea.append("my text \n");
        add(jsp);

//        ActionListener send =new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textArea.append(textField.getText() +"\n");
//                textField.setText("");
//            }
//        };

        ActionListener send = e -> {
            textArea.append(textField.getText() + "\n");
            textField.setText("");
        };

        textField.addActionListener(send);
        btnSend.addActionListener(send);


        JPanel panelW = new JPanel();
        panelW.setLayout(new BoxLayout(panelW, BoxLayout.Y_AXIS));
        JCheckBox italicBox = new JCheckBox("<html><i>Italic</i><html>");
        JCheckBox boldBox = new JCheckBox("Bold");
        panelW.add(italicBox);
        panelW.add(boldBox);
        add(panelW, BorderLayout.WEST);


        Font font = new Font(fontName, style, size);
        textArea.setFont(font);

        ChangeListener changeListener = e -> {
            style = boldBox.isSelected() ? 1 : 0;
            style += italicBox.isSelected() ? 2 : 0;
            textArea.setFont(new Font(fontName, style, size));
        };

        boldBox.addChangeListener(changeListener);
        italicBox.addChangeListener(changeListener);

//        CTRL+ALT+L

        JPanel panelRadioButtuns = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton radioButton18 = new JRadioButton("18 px");
        JRadioButton radioButton30 = new JRadioButton("30 px", true);
        JRadioButton radioButton48 = new JRadioButton("48 px");

        panelRadioButtuns.add(radioButton18);
        panelRadioButtuns.add(radioButton30);
        panelRadioButtuns.add(radioButton48);

        buttonGroup.add(radioButton18);
        buttonGroup.add(radioButton30);
        buttonGroup.add(radioButton48);

        panelW.add(panelRadioButtuns);

        ActionListener actionListener = e -> {
            if (radioButton18.isSelected()) {
                size = 18;
            }
            if (radioButton30.isSelected()) {
                size = 30;
            }
            if (radioButton48.isSelected()) {
                size = 48;
            }
            textArea.setFont(new Font(fontName, style, size));
        };

        radioButton18.addActionListener(actionListener);
        radioButton30.addActionListener(actionListener);
        radioButton48.addActionListener(actionListener);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Bue!");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Activated!!!");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("DeActivated!!!");
            }
        });

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println(e.getX() + " " + e.getY());
                textArea.setBackground(Color.getHSBColor(
                        (float) Math.random(),
                        (float) Math.random(),
                        (float) Math.random() * 0.2f + 0.8f
                ));
            }
        });

        textArea.setCaretColor(new Color(0, 255, 0));
        textArea.setForeground(new Color(0, 0, 255));
        textArea.setSelectionColor(new Color(255, 255, 0));
        textArea.setSelectedTextColor(new Color(255, 0, 0));

        setVisible(true);
    }
}
