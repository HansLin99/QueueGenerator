package UI;

import java.io.IOException;

public class SequenceStarter {
    public static void main(String[] args) throws IOException {

        InteractionProcess ui = new InteractionProcess();
        WebDisplay wb = new WebDisplay();
        wb.displayWelcome();
        ui.enterInfo();

    }




}
