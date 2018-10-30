package CustomerData;

import java.util.List;

public class RegularCustomer extends Customer {

    @Override
    public void addCustomer(List<Customer> queue, Customer customer) {
        queue.add(customer);
    }

}
