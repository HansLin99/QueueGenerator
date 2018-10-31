package CustomerData;


import Interfaces.User;

import java.util.List;

public abstract class Customer implements User {


    private String name = "";
    private int position = 0;
    private String phoneNumber = "";
    private boolean ifReserved = false;






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
}
