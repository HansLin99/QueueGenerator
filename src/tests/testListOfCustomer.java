package tests;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class testListOfCustomer {
    Customer testC;
    ListOfCustomer testQ;


    @BeforeEach
    void setUp() {
        testC = new Customer();
        testQ = new ListOfCustomer();

    }

    @Test
    void testAddCustomer() {
        assertEquals(0, testQ.queue.size());
        testQ.addCustomer(testC);
        assertTrue(testQ.queue.contains(testC));
    }

    @Test
    void testRemoveCustomer() {
        testQ.addCustomer(testC);
        assertTrue(testQ.queue.contains(testC));
        testQ.removeCustomer(testC);
        assertFalse(testQ.queue.contains(testC));
    }

    @Test
    void testResetQueue() {
        testQ.addCustomer(testC);
        assertEquals(1, testQ.queue.size());
        testQ.resetQueue();
        assertEquals(0, testQ.queue.size());

    }

    @Test
    void testGetCustomer() {
        assertEquals(0, testQ.getCustomerSequence(testC));
        testC.name = "Hans";
        testC.position = 1;
        testQ.addCustomer(testC);
        assertEquals(1, testQ.getCustomerSequence(testC));
    }

}
