package Tests;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import CustomerData.RegularCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


 class testListOfCustomer {
    Customer testC;
    ListOfCustomer testQ;


    @BeforeEach
    void setUp() {
        testC = new RegularCustomer();
        testQ = new ListOfCustomer();

    }

    @Test
    void testAddCustomer() {
        assertEquals(0, testQ.getQueue().size());
        testQ.addCustomer(testC);
        assertTrue(testQ.getQueue().contains(testC));
    }

    @Test
    void testRemoveCustomer() {
        testQ.addCustomer(testC);
        assertTrue(testQ.getQueue().contains(testC));
        testQ.removeCustomer(testC);
        assertFalse(testQ.getQueue().contains(testC));
    }

    @Test
    void testResetQueue() {
        testQ.addCustomer(testC);
        assertEquals(1, testQ.getQueue().size());
        testQ.resetQueue();
        assertEquals(0, testQ.getQueue().size());

    }

    @Test
    void testGetCustomer() {
        assertEquals(0, testQ.getCustomerSequence(testC));
        testC.setName("Hans");
        testC.setPosition(1);
        testQ.addCustomer(testC);
        assertEquals(1, testQ.getCustomerSequence(testC));
    }

    @Test
    void testThisCustomer() {
        testC.setName("Hans");
        testQ.thisCustomer(testC);
        assertEquals(1, testC.getPosition());
        testQ.addCustomer(testC);
        assertEquals(1, testC.getPosition());
        Customer testR = new RegularCustomer();
        testR.setName("Kai");
        testQ.thisCustomer(testR);
        assertEquals(2, testR.getPosition());
        testQ.addCustomer(testR);
        testQ.thisCustomer(testR);
        assertEquals(2, testR.getPosition());
    }


    @Test
     void testSearchCustomer(){

    }

}
