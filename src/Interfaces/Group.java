package Interfaces;

import CustomerData.Customer;

public interface Group {
    //REQUIRE:position greater than or equal to 0 and less than the s
    // ize-1
    //MODIFY:this
    //EFFECT:RemoveButton any customer out of the queue if not in the queue
    void removeCustomer(Customer c);

    //REQUIRE:position greater than or equal to 0 and less than the size-1
    //MODIFY:this
    //EFFECT:AddButton customer into the queue
    void addCustomer(Customer c);

    //REQUIRE:nothing
    //MODIFY:this
    //EFFECT:reset the queue size to 0, RemoveButton all customer Info
    void resetQueue();

    //REQUIRE:position greater than or equal to 0 and less than the size-1
    //MODIFY:nothing
    //EFFECT:get the customer in given position
    int getCustomerSequence(Customer c);

}
