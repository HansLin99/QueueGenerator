package UI.buttons;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import CustomerData.RegularCustomer;
import CustomerData.ReservedCustomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JFrame implements ActionListener {
    private JLabel nameInstruction;
    private JLabel phoneNumInstruction;
    private JLabel output;
    private JPanel namePanel;
    private JPanel phoneNumPanel;
    private JPanel confirmPanel;
    private JButton confirm;
    private JTextField name;
    private JTextField phoneNum;
    private ListOfCustomer queue;

    public Add(ListOfCustomer queue) {
        super("Please enter customer information");
        this.queue = queue;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(3, 0));

        namePanel = new JPanel();
        phoneNumPanel = new JPanel();
        confirmPanel = new JPanel();
        confirm = new JButton("Confirm");
        name = new JTextField();
        phoneNum = new JTextField();
        nameInstruction = new JLabel("Please enter the name of the customer:");
        phoneNumInstruction = new JLabel("Please enter the phone number of the customer:");
        output = new JLabel();

        namePanel.add(name);
        namePanel.add(nameInstruction);
        phoneNumPanel.add(phoneNum);
        phoneNumPanel.add(phoneNumInstruction);
        confirmPanel.add(confirm);
        confirmPanel.add(output);

        Container pane = getContentPane();

        pane.add(namePanel);
        pane.add(phoneNumPanel);
        pane.add(confirmPanel);

        pack();
        setVisible(true);

        confirm.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nameEntered = name.getText();
        String phoneNumEntered = phoneNum.getText();
        ReservedCustomer customer = new ReservedCustomer();
        customer.setName(nameEntered);
        customer.setPhoneNumber(phoneNumEntered);
        queue.addCustomer(customer);
    }
}
