package CustomerData;

import java.util.List;

public class ReservedCustomer extends Customer {

    public ReservedCustomer() {
        super();
    }

    @Override
    public void addCustomer(List<Customer> queue, Customer customer) {
        queue.add(customer.getPosition()-1,customer);
    }


}
