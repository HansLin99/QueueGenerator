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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RemoveButton extends JFrame implements ActionListener , WindowListener {
    private JLabel nameInstruction;
    private JLabel output;
    private JPanel namePanel;
    private JPanel confirmPanel;
    private JButton confirm;
    private JTextField name;
    private static ListOfCustomer queue;
    private static FunctionMain functionMain;

    public RemoveButton(ListOfCustomer queue, FunctionMain functionMain) {
        super("Please enter customer information");
        this.queue = queue;
        this.functionMain = functionMain;
        setLocation(500,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(this);
        setResizable(false);
        setSize(500, 150);
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
            queue.removeCustomer(c);
            queue.moveQueueBehindRemovedCustomerForward(c);
            output.setForeground(Color.BLACK);
            output.setText("Remove successfully!");
            name.setText("");
            try {
                queue.saveData();
            } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

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
