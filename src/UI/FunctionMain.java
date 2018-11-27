package UI;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import UI.buttons.Add;
import UI.buttons.Remove;
import UI.buttons.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FunctionMain extends JFrame implements ActionListener {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 400;
    private ListOfCustomer queue;
    private JButton addCustomer;
    private JButton removeCustomer;
    private JButton clearQueue;
    private JButton quit;
    private JButton searchCustomer;
    private JButton moveOneForward;
    private JPanel instructions;

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
        searchCustomer = new JButton("Search Customer");
        quit = new JButton("Quit");
        JPanel buttons = new JPanel();
        instructions = new JPanel();
        moveOneForward = new JButton("Update one");


        buttons.add(addCustomer);
        buttons.add(removeCustomer);
        buttons.add(searchCustomer);
        buttons.add(clearQueue);
        buttons.add(moveOneForward);
        buttons.add(quit);
        instructions.add(initializeQueueInfoDisplay());

        pane.add(instructions, BorderLayout.CENTER);
        pane.add(buttons, BorderLayout.SOUTH);


        pack();
        setVisible(true);

        addCustomer.addActionListener(this);
        removeCustomer.addActionListener(this);
        clearQueue.addActionListener(this);
        searchCustomer.addActionListener(this);
        moveOneForward.addActionListener(this);
        quit.addActionListener(this);


    }

    private JLabel initializeQueueInfoDisplay() throws IOException {
        JLabel instruction = new JLabel("<html>" + CurrentQueueInfo().replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "<html>");

        return instruction;
    }

    private String CurrentQueueInfo() throws IOException {
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
            new Add(queue);
        } else if (e.getSource().equals(removeCustomer)) {
            new Remove();
        } else if (e.getSource().equals(clearQueue)) {
            queue.resetQueue();
            try {
                queue.saveData();
            } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                System.out.println("Save failed! Please check the queue!");
            }
            instructions.setVisible(false);
            getContentPane().remove(instructions);
        } else if (e.getSource().equals(searchCustomer)){
            new Search();
        } else if (e.getSource().equals(quit)) {
            dispose();
            try {
                new SequenceStarter();
            } catch (IOException e1) {
                System.out.println("Error!");
            }
        } else if (e.getSource().equals(moveOneForward)) {
            queue.moveForwardQueue();
            try {
                queue.saveData();
            } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                System.out.println("Save failed! Please check!");
            }
        }
    }
}
