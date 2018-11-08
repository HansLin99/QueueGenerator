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
        assertEquals(0, testQ.getCustomers().size());
        testQ.addCustomer(testC);
        assertTrue(testQ.getCustomers().contains(testC));
    }

    @Test
    void testRemoveCustomer() {
        testQ.addCustomer(testC);
        assertTrue(testQ.getCustomers().contains(testC));
        testQ.removeCustomer(testC);
        assertFalse(testQ.getCustomers().contains(testC));
    }

    @Test
    void testResetQueue() {
        testQ.addCustomer(testC);
        assertEquals(1, testQ.getCustomers().size());
        testQ.resetQueue();
        assertEquals(0, testQ.getCustomers().size());

    }

    @Test
    void testGetCustomer() {
        assertEquals(0, testQ.getCustomerSequence(testC));
        testC.setName("Hans");
        testC.setPosition(1);
        testQ.addCustomer(testC);
        assertEquals(1, testQ.getCustomerSequence(testC));
    }



}
