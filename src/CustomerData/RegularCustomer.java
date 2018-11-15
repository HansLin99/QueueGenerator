package CustomerData;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RegularCustomer extends Customer{

    public RegularCustomer() {
        super();
    }

    @Override
    public void addCustomer(List<Customer> queue, Customer customer) {
        queue.add(customer);
    }

    @Override
    public void update() {
        System.out.println("The latest position is "+ getPosition());
    }
}
