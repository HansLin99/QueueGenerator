package UI.buttons;


import CustomerData.ListOfCustomer;
import CustomerData.ReservedCustomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class AddButton extends JFrame implements ActionListener {
    private JLabel nameInstruction;
    private JLabel phoneNumInstruction;
    private JLabel output;
    private JPanel namePanel;
    private JPanel phoneNumPanel;
    private JPanel confirmPanel;
    private JButton confirm;
    private JTextField name;
    private JTextField phoneNum;
    private static ListOfCustomer queue;

    public AddButton(ListOfCustomer queue) {
        super("Please enter customer information");
        this.queue = queue;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(500, 200);
        setLayout(new GridLayout(3, 0));

        namePanel = new JPanel();
        phoneNumPanel = new JPanel();
        confirmPanel = new JPanel();
        confirm = new JButton("Confirm");
        name = new JTextField(10);
        phoneNum = new JTextField(10);
        nameInstruction = new JLabel("Please enter the name of the customer:");
        phoneNumInstruction = new JLabel("Please enter the phone number of the customer:");
        output = new JLabel();

        namePanel.add(nameInstruction);
        namePanel.add(name);
        phoneNumPanel.add(phoneNumInstruction);
        phoneNumPanel.add(phoneNum);
        confirmPanel.add(output);
        confirmPanel.add(confirm);


        Container pane = getContentPane();

        pane.add(namePanel);
        pane.add(phoneNumPanel);
        pane.add(confirmPanel);


        setVisible(true);

        confirm.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nameEntered = name.getText();
        String phoneNumEntered = phoneNum.getText();
        if (nameEntered.equals("")|phoneNumEntered.equals("")){
            output.setText("Please enter valid information.");
        } else if (!queue.ifAlreadyInQueue(nameEntered)) {
            ReservedCustomer customer = new ReservedCustomer();
            customer.setName(nameEntered);
            customer.setPhoneNumber(phoneNumEntered);
            customer.setPosition(queue.getCustomers().size() + 1);
            queue.addCustomer(customer);
            output.setText("Add successfully!");
            name.setText("");
            phoneNum.setText("");
            try {
                queue.saveData();
            } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

        } else {
            output.setText("The customer you enter is already in the queue. Please re-enter a customer.");
            name.setText("");
            phoneNum.setText("");
        }
    }
}
