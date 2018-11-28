package UI.buttons;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import UI.FunctionMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class SearchButton extends JFrame implements ActionListener , WindowListener {
    private JLabel nameInstruction;
    private JLabel output;
    private JPanel namePanel;
    private JPanel confirmPanel;
    private JButton confirm;
    private JTextField name;
    private static ListOfCustomer queue;
    private static FunctionMain functionMain;

    public SearchButton(ListOfCustomer queue, FunctionMain functionMain) {
        super("Please enter customer information");
        addWindowListener(this);
        this.queue = queue;
        this.functionMain = functionMain;
        setLocation(500,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(500, 200);
        setLayout(new GridLayout(2, 0));

        namePanel = new JPanel();
        confirmPanel = new JPanel();
        confirm = new JButton("Confirm");
        name = new JTextField(10);
        nameInstruction = new JLabel("Please enter the name of the customer:");
        output = new JLabel();

        namePanel.add(nameInstruction);
        namePanel.add(name);
        confirmPanel.add(output);
        confirmPanel.add(confirm);


        Container pane = getContentPane();

        pane.add(namePanel);
        pane.add(confirmPanel);


        setVisible(true);

        confirm.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nameEntered = name.getText();
        if (nameEntered.equals("")){
            output.setForeground(Color.RED);
            output.setText("Please enter valid information.");
        } else if (queue.ifAlreadyInQueue(nameEntered)) {
            Customer c = queue.customerFoundByName(nameEntered);
            output.setForeground(Color.BLACK);
            output.setText("<html>" + "Your name is:" + c.getName() + "<br/>" + "Your current position is:" + c.getPosition() + "<html>");

        } else {
            output.setForeground(Color.BLUE);
            output.setText("The customer you enter is not in the queue. Please re-enter a customer.");
            name.setText("");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            functionMain.getDisplay().setText(functionMain.infoDisplay());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
