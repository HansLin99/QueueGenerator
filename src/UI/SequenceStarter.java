package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SequenceStarter extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    public SequenceStarter()  throws IOException {
        super("SequenceGenerator");
        initialGraphing();
        InteractionProcess ui = new InteractionProcess();
        WebDisplay wb = new WebDisplay();
        wb.displayWelcome();
        ui.enterInfo();

    }

    public static void main(String[] args) throws IOException {
        new SequenceStarter();


    }

    private void initialGraphing(){
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }


}
