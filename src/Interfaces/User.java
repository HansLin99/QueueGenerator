package Interfaces;

import CustomerData.Customer;

public interface User {


    //MODIFY:this
    //EFFECTS:change the customer's name to the name entered
    void addName(String name);

    //MODIFY:this
    //EFFECTS:change the customer's phone number to the phoneNum entered
    void addPhoneNumber(String phoneNum);


}
