package Tests;

import CustomerData.ListOfCustomer;
import CustomerData.RegularCustomer;
import Exceptions.WrongInstructionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class testExceptions {
    ListOfCustomer testQueue;
    RegularCustomer hans;
    RegularCustomer kai;
    RegularCustomer roxy;
    RegularCustomer kevin;


    @BeforeEach
    void setUp(){
        testQueue = new ListOfCustomer();
        hans = new RegularCustomer();
        roxy = new RegularCustomer();
        kai  = new RegularCustomer();
        kevin = new RegularCustomer();
        hans.name = "Hans";
        roxy.name = "Roxy";
        kai.name  = "Kai";
        kevin.name = "Kevin";
        testQueue.addCustomer(hans);
        testQueue.addCustomer(roxy);
        testQueue.addCustomer(kai);
        testQueue.addCustomer(kevin);
    }


    @Test
    void testSearchCustomerWrongInstructionException(){
        String testFunction = "search";
//        try {
//            testQueue.innerFunction(testFunction, hans);
//        } catch (WrongInstructionException e) {
//
//        }


    }
}
