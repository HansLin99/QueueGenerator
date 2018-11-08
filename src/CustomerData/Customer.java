package CustomerData;


import Exceptions.UserNotInQueueException;
import Interfaces.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class Customer implements User {


    private String name = "";
    private int position = 0;
    private String phoneNumber = "";
    private boolean ifReserved = false;
    private ListOfCustomer fellows;
    private HashMap<Customer, List<Customer>> group;

    public Customer() {
        group = new HashMap<>();
        fellows = new ListOfCustomer();
    }


    //MODIFIES:this
    //EFFECTS:add the customer and his fellow to a group
    public void addCustomerIntoGroup(Customer fellowLeader, ListOfCustomer fellows) {
        this.fellows = fellows;
        group.put(fellowLeader, fellowLeader.getFellows().getQueue());
    }

    //MODIFIES:this
    //EFFECTS:add the customer into fellow
    public void addFellows(Customer customer) {
        if (!customer.getFellows().getQueue().contains(customer)) {
            customer.getFellows().getQueue().add(customer);
        }
    }


    //MODIFIES:this
    //EFFECTS:remove the customer into fellow
    public void removeFellows(Customer customer) throws UserNotInQueueException {
        if (!customer.getFellows().getQueue().contains(customer)){
            throw new UserNotInQueueException();
        }
        else customer.getFellows().getQueue().remove(customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    //MODIFY:this
    //EFFECTS:change the customer's name to the name entered
    public void setName(String name){
        this.name = name;
    }

    //MODIFY:this
    //EFFECTS:change the customer's phone number to the phoneNum entered
    public void setPhoneNumber(String phoneNum){
        this.phoneNumber = phoneNum;
    }

    public void addCustomer(Customer customer, String name, String phoneNum) {
        if (name.equals("")){
        setPhoneNumber(phoneNum);}
        else if (phoneNum.equals("")) {
            setName(name);}
    }

    public abstract void addCustomer(List<Customer> queue, Customer customer);

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isIfReserved() {
        return ifReserved;
    }

    public void setIfReserved(boolean ifReserved) {
        this.ifReserved = ifReserved;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public HashMap<Customer, List<Customer>> getGroup() {
        return group;
    }


    public ListOfCustomer getFellows() {
        return fellows;
    }

    public void addFellows(ListOfCustomer fellows) {
        if (!ifContainInTheQueue(this, fellows)) {
            fellows.getQueue().add(this);
            fellows.addFellowLeader(this);
        }
    }

    public void removeFellows(ListOfCustomer fellows) {
        if (ifContainInTheQueue(this, fellows)) {
            fellows.getQueue().remove(this);
            fellows.removeFellowLeader(this);
        }
    }

    private boolean ifContainInTheQueue(Customer customer, ListOfCustomer fellows) {
       return fellows.getQueue().contains(customer);
    }
}
