package UI;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import UI.buttons.AddButton;
import UI.buttons.RemoveButton;
import UI.buttons.SearchButton;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static javax.swing.ScrollPaneConstants.*;

public class FunctionMain extends JFrame implements ActionListener {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 400;
    private static ListOfCustomer queue;
    private JButton addCustomer;
    private JButton removeCustomer;
    private JButton clearQueue;
    private JButton quit;
    private JButton searchCustomer;
    private JButton moveOneForward;
    private JLabel display;
    private JPanel displayPanel;
    private JScrollPane scrollPane;

    public FunctionMain() throws IOException {
        super("Functions");
        setLocation(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout(10, 20));


        queue = new ListOfCustomer();
        Container pane = getContentPane();
        addCustomer = new JButton("Add Customer");
        removeCustomer = new JButton("Remove Customer");
        clearQueue = new JButton("Clear Queue");
        searchCustomer = new JButton("Search Customer");
        quit = new JButton("Quit");
        JPanel buttons = new JPanel();
        displayPanel = new JPanel();
        moveOneForward = new JButton("Update one");
        Font font = new Font("SansSerif", Font.BOLD, 35);



        buttons.add(addCustomer);
        buttons.add(removeCustomer);
        buttons.add(searchCustomer);
        buttons.add(clearQueue);
        buttons.add(moveOneForward);
        buttons.add(quit);

        display = new JLabel(infoDisplay());
        display.setFont(font);
        display.setForeground(Color.PINK);
        displayPanel.add(display);


        scrollPane = new JScrollPane(displayPanel);
        add(scrollPane);
//      pane.add(displayPanel, BorderLayout.NORTH);
        pane.add(buttons, BorderLayout.SOUTH);



        setVisible(true);

        addCustomer.addActionListener(this);
        removeCustomer.addActionListener(this);
        clearQueue.addActionListener(this);
        searchCustomer.addActionListener(this);
        moveOneForward.addActionListener(this);
        quit.addActionListener(this);


    }

    String CurrentQueueInfo() throws IOException {
        StringBuilder instruction = new StringBuilder("The current queue is :"
                + "\n");

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
            new AddButton(queue,this);
        } else if (e.getSource().equals(removeCustomer)) {
            new RemoveButton(queue,this);
        } else if (e.getSource().equals(clearQueue)) {
            queue.resetQueue();
            try {
                queue.saveData();
            } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                System.out.println("Save failed! Please check the queue!");
            }
            try {
                display.setText(infoDisplay());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource().equals(searchCustomer)){
            new SearchButton(queue,this);
        } else if (e.getSource().equals(quit)) {
            dispose();
            try {
                new SequenceStarter();
            } catch (IOException | JSONException e1) {
                System.out.println("Error!");
            }
        } else if (e.getSource().equals(moveOneForward)) {
            queue.moveForwardQueue();
            try {
                queue.saveData();
                display.setText(infoDisplay());
            } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                System.out.println("Save failed! Please check!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public JLabel getDisplay() {
        return display;
    }

    public String infoDisplay() throws IOException {
        return "<html>" + CurrentQueueInfo().replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "<html>";
    }
}
