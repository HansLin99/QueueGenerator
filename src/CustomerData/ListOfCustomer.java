package CustomerData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exceptions.UserNotInQueueException;
import FileReaderWriter.FileReaderUser1;
import FileReaderWriter.FileWriterUser1;
import Interfaces.Group;
import observer.Subject;

public class ListOfCustomer extends Subject implements Group, Iterable<Customer>  {
    private List<Customer> customers;
    private Customer fellowLeader;
    private boolean notInTheQueue = false;

    //EFFECTS:generate the customers given a list of customers
    public ListOfCustomer() {
        customers = new ArrayList<>();
    }


    //MODIFIES:this
    //EFFECT: pass the customer to AddButton his/her fellows
    public void addFellows(Customer fellowLeader, ListOfCustomer fellows) {
        this.fellowLeader = fellowLeader;
        fellowLeader.addCustomerIntoGroup(this.fellowLeader, fellows);
    }


    //REQUIRE:position greater than or equal to 0 and less than the s
    // ize-1
    //MODIFY:this
    //EFFECT:RemoveButton any customer out of the customers if not in the customers
    public void removeCustomer(Customer c) {
        if (isContains(c, customers)) {
            customers.remove(c);
        } else System.out.println("The customer you want to RemoveButton is not in the customers.");
    }


    @Override
    //REQUIRE:position greater than or equal to 0 and less than the size-1
    //MODIFY:this
    //EFFECT:AddButton customer into the customers
    public void addCustomer(Customer c) {
        if (!isContains(c, customers)) {
           customers.add(c);
           addObserver(c);
        } else System.out.println("The customer you want to AddButton is already in the customers.");
    }

    private boolean isContains(Customer c, List<Customer> queue) {
        return queue.contains(c);
    }


    //REQUIRE:nothing
    //MODIFY:this
    //EFFECT:reset the customers size to 0, RemoveButton all customer Info
    public void resetQueue() {
        customers.clear();
    }

    //REQUIRE:position greater than or equal to 0 and less than the size-1
    //MODIFY:nothing
    //EFFECT:get the customer in given position
    public int getCustomerSequence(Customer c) {
        return getSequence(c);
    }


    //REQUIRE:a customer name in the customers
    //MODIFY:nothing
    //EFFECT:get the position of the customer in the customers
    private int getSequence(Customer c) {
        for (Customer customer : customers) {
            if (customer.getName().equals(c.getName())) {
                return customer.getPosition();
            }
        }

        return 0;
    }

    //EFFECTS:if customer's name could be found in the customers, return true, false otherwise
    public boolean ifAlreadyInQueue(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    //EFFECTS:SearchButton for customer who has the given name and print his information
    public void searchCustomer(String name) throws UserNotInQueueException {
        Customer searchingCustomer = customerFoundByName(name);
        if (!(searchingCustomer == null)) {
            System.out.println("Your name is " + searchingCustomer.getName() + ".");
            System.out.println("Your phone number is " + searchingCustomer.getPhoneNumber() + ".");
            System.out.println("Your position in the customers is " + searchingCustomer.getPosition() + ".");
            notInTheQueue = false;
        } else throw new UserNotInQueueException();
    }

    //Helper
    public Customer customerFoundByName(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }

        }
        return null;
    }



    public boolean isNotInTheQueue() {
        return notInTheQueue;
    }

    public void setNotInTheQueue(boolean notInTheQueue) {
        this.notInTheQueue = notInTheQueue;
    }

    public void saveData() throws FileNotFoundException, UnsupportedEncodingException {
        FileWriterUser1 w = new FileWriterUser1();
        w.writeData(customers);
    }

    public void readData() throws IOException {
        FileReaderUser1 r = new FileReaderUser1();
        this.customers = r.readData().customers;


    }

    public void moveForwardQueue() {
        if (customers.size()!=0) {
            customers.remove(0);

            for (Customer customer : customers) {
                if (customer.getPosition() > 0) {
                    customer.setPosition(customer.getPosition() - 1);
                }
            }
            notifyObserver();
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }


    void addFellowLeader(Customer fellowLeader) {
        if (!isContains(fellowLeader, this.getCustomers())) {
            this.customers.add(fellowLeader);
            fellowLeader.addFellows(this);
        }
    }

    void removeFellowLeader(Customer fellowLeader) {
        if (isContains(fellowLeader, this.getCustomers())) {
            this.customers.remove(fellowLeader);
            fellowLeader.removeFellows(this);
        }
    }


    public void moveQueueBehindRemovedCustomerForward(Customer c) {
        for (Customer customer:customers) {
            if (customer.getPosition()>c.getPosition()){
                customer.setPosition(customer.getPosition()-1);
            }
        }
    }

    @Override
    public Iterator<Customer> iterator() {
        return customers.iterator();
    }
}
