package Interfaces;

import CustomerData.Customer;
import Exceptions.WrongInstructionException;

import java.util.ArrayList;

public interface Sequence {
    //REQUIRE:position greater than or equal to 0 and less than the s
    // ize-1
    //MODIFY:this
    //EFFECT:remove any customer out of the queue if not in the queue
    void removeCustomer(Customer c);

    //REQUIRE:position greater than or equal to 0 and less than the size-1
    //MODIFY:this
    //EFFECT:add customer into the queue
    void addCustomer(Customer c);

    //REQUIRE:nothing
    //MODIFY:this
    //EFFECT:reset the queue size to 0, clear all customer Info
    void resetQueue();

    //REQUIRE:position greater than or equal to 0 and less than the size-1
    //MODIFY:nothing
    //EFFECT:get the customer in given position
    int getCustomerSequence(Customer c);

    //MODIFY:this
    //EFFECT:if the customer is in the queue, print the position, otherwise generate a new position
    void thisCustomer(Customer c);

    //EFFECT:command to next step
    void functions(Customer c, String s) throws WrongInstructionException;

}
