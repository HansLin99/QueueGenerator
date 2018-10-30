package CustomerData;


import Interfaces.User;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements User {


    public String name = "";
    public int position = 0;
    public String phoneNumber = "";
    public boolean ifReserved = false;






    //MODIFY:this
    //EFFECTS:change the customer's name to the name entered
    private void addName(String name){
        this.name = name;
    }

    //MODIFY:this
    //EFFECTS:change the customer's phone number to the phoneNum entered
    private void addPhoneNumber(String phoneNum){
        this.phoneNumber = phoneNum;
    }

    public void addCustomer(Customer customer, String name, String phoneNum) {
        if (name.equals("")){
        addPhoneNumber(phoneNum);}
        else if (phoneNum.equals("")) {addName(name);}
    }

    public abstract void addCustomer(List<Customer> queue, Customer customer);




    //REQUIRE:nothing
    //MODIFY:nothing
    //EFFECT:get the Info of the customer including name and phone number
    public void getInfoCustomer(Customer c){
        //stub
    }


    //EFFECT:send a text message to inform the customer to be seated
    public void sentText(){
        //stub
    }





}
