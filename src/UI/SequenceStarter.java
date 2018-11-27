package UI;

import org.json.JSONException;
import sun.tools.jps.Jps;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SequenceStarter extends JFrame implements ActionListener {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private JPanel weather;
    private JPanel enterButton;
//    private JLabel background;
//    private JPanel backgroundPanel;


    public SequenceStarter() throws IOException, JSONException {

        super("Sequence Generator");

        setLocation(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setResizable(false);


        setLayout(new BorderLayout());

        JButton enter = new JButton("Enter");
        WebDisplay wb = new WebDisplay();
        weather = new JPanel();
//        background= new JLabel();
//        backgroundPanel = new JPanel();
//        background.setIcon(new ImageIcon("background.jpg"));
//        backgroundPanel.add(background);
        enterButton = new JPanel();
        JLabel weatherInfo = new JLabel("<html><div style='text-align: center;'>"+
                wb.parseJson().replaceAll("<","&lt;")
                        .replaceAll(">", "&gt;").replaceAll("\n", "<br/>")
                +"</div></html>");
        Font font = new Font("SansSerif", Font.ITALIC, 35);
        weatherInfo.setFont(font);
        weather.add(weatherInfo);
        enterButton.add(enter);
        Container panel = getContentPane();

//        panel.add(backgroundPanel);
        panel.add(weather, BorderLayout.PAGE_START);
        panel.add(enterButton, BorderLayout.SOUTH);


        enter.addActionListener(this);



        setVisible(true);



    }

    public static void main(String[] args) throws IOException, JSONException {
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
