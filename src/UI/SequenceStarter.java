package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SequenceStarter extends JFrame implements ActionListener {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 400;

//    private JLabel weatherInfo;
//    private JFrame main;
//    private Container panel;
//    private JButton enter;


    public SequenceStarter()  throws IOException {

        super("Sequence Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setResizable(false);


        setLayout(new BorderLayout());

        JButton enter = new JButton("Enter");
        WebDisplay wb = new WebDisplay();
        JLabel weatherInfo = new JLabel("<html><div style='text-align: center;'>"+
                wb.parseJson().replaceAll("<","&lt;")
                        .replaceAll(">", "&gt;").replaceAll("\n", "<br/>")
                +"</div></html>");
        Container panel = getContentPane();

        panel.add(weatherInfo, BorderLayout.PAGE_START);
        panel.add(enter, BorderLayout.SOUTH);
        pack();
        setVisible(true);

        enter.addActionListener(this);




    }

    public static void main(String[] args) throws IOException {
        new SequenceStarter();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        try {
            new FunctionMain();
        } catch (IOException e1) {
            System.out.println("The output of the queue is wrong!");
        }

    }




}
