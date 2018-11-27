package UI.buttons;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SearchButton extends JFrame implements ActionListener {
    private JLabel nameInstruction;
    private JLabel output;
    private JPanel namePanel;
    private JPanel confirmPanel;
    private JButton confirm;
    private JTextField name;
    private static ListOfCustomer queue;

    public SearchButton(ListOfCustomer queue) {
        super("Please enter customer information");
        this.queue = queue;
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
            output.setText("Please enter valid information.");
        } else if (queue.ifAlreadyInQueue(nameEntered)) {
            Customer c = queue.customerFoundByName(nameEntered);
            output.setText("<html>" + "Your name is:" + c.getName() + "<br/>" + "Your current position is:" + c.getPosition() + "<html>");

        } else {
            output.setText("The customer you enter is not in the queue. Please re-enter a customer.");
            name.setText("");
        }
    }
}
