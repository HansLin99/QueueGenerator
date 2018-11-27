package UI;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import UI.buttons.add;
import UI.buttons.clear;
import UI.buttons.remove;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FunctionMain extends JFrame implements ActionListener {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 400;
    private ListOfCustomer queue;
    private JButton addCustomer;
    private JButton removeCustomer;
    private JButton clearQueue;
    private JButton quit;

    FunctionMain() throws IOException {
        super("Functions");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout(10, 20));


        Container pane = getContentPane();
        addCustomer = new JButton("Add Customer");
        removeCustomer = new JButton("Remove Customer");
        clearQueue = new JButton("Clear Queue");
        quit = new JButton("Quit");
        JPanel buttons = new JPanel();
        JPanel instructions = new JPanel();
        JLabel instruction = new JLabel("<html>" + instruction().replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "<html>");

        buttons.add(addCustomer);
        buttons.add(removeCustomer);
        buttons.add(clearQueue);
        buttons.add(quit);
        instructions.add(instruction);
        pane.add(instructions, BorderLayout.CENTER);
        pane.add(buttons, BorderLayout.SOUTH);


        pack();
        setVisible(true);

        addCustomer.addActionListener(this);
        removeCustomer.addActionListener(this);
        clearQueue.addActionListener(this);
        quit.addActionListener(this);


    }

    private String instruction() throws IOException {
        StringBuilder instruction = new StringBuilder("The current queue is :"
                + "\n");
        queue = new ListOfCustomer();
        queue.readData();

        for (Customer customer : queue.getCustomers()) {
            instruction.append(customer.getName()).append("        ");
            instruction.append(customer.getPhoneNumber()).append("        ");
            instruction.append(customer.getPosition()).append("        ").append("\n");
        }

        return instruction.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addCustomer)) {
            new add();
        } else if (e.getSource().equals(removeCustomer)) {
            new remove();
        } else if (e.getSource().equals(clearQueue)) {
            new clear();
        } else if (e.getSource().equals(quit)) {

        }
    }
}
