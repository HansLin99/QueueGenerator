package Tests;


import CustomerData.Customer;
import CustomerData.RegularCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class testCustomer {



    Customer testC;



    @BeforeEach
    void setup(){
        testC = new RegularCustomer();
        ((Customer) testC).setName("");
        ((Customer) testC).setPhoneNumber("");
    }

    @Test
    void testAddName(){
        assertEquals("", ((Customer) testC).getName());
        testC.addCustomer(testC,"Hans", "");
        assertEquals("Hans", ((Customer) testC).getName());
    }

    @Test
    void testAddPhoneNumber(){
        assertEquals("", ((Customer) testC).getPhoneNumber());
        testC.addCustomer(testC,"", "7783236355");
        assertEquals("7783236355", ((Customer) testC).getPhoneNumber());
    }

}
