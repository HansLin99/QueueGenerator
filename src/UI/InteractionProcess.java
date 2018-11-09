package UI;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import CustomerData.RegularCustomer;
import CustomerData.ReservedCustomer;
import Exceptions.UserNotInQueueException;
import Exceptions.WrongInstructionException;

import java.io.IOException;
import java.util.Scanner;

class InteractionProcess {
     private ListOfCustomer queue;


    public InteractionProcess() throws IOException {
        queue = new ListOfCustomer();
        queue.readData();
    }

    //REQUIRE:nothing
    //MODIFY:this
    //EFFECT:get the name and the phoneNumber of the customer
    public void enterInfo() throws IOException {
        while (true){
            Scanner s = new Scanner(System.in);
            Customer customer;
            System.out.println("Did you reserve?");
            String ifReservedEntered = s.nextLine();
            if (ifReservedEntered.equals("Yes") || ifReservedEntered.equals("yes")){
                customer = new ReservedCustomer();
                customer.setIfReserved(true);
            }
            else customer = new RegularCustomer();
            System.out.println("Please enter the name of the customer:");
            customer.addCustomer(customer, s.nextLine(), "");
            System.out.println("Please enter the phone number of this customer");
            customer.addCustomer(customer, "", s.nextLine());
            System.out.println("If the customer has fellows? (Yes or No)");
            try {
                if (hasFellows(s.nextLine())){
                    ListOfCustomer fellows = new ListOfCustomer();
                    while (true){
                        System.out.println("Enter the name of the fellow:)");
                        Customer fellow = new RegularCustomer();
                        fellow.setName(s.nextLine());
                        System.out.println("Enter the phone number of the fellow:");
                        fellow.setPhoneNumber(s.nextLine());
                        System.out.println("enter no more if no more fellows otherwise keep adding fellows");
                        fellows.getCustomers().add(fellow);
                        if (s.nextLine().equals("no more")){
                            break;
                        }
                    }
                    queue.addFellows(customer, fellows);
                }
            } catch (WrongInstructionException e) {
                System.out.println("The instruction you given is invalid.");
            }
            thisCustomer(customer, queue);
            System.out.println("Please select a function (add,remove,reset,search or pass (no function))");
            try {
                functions(customer, queue, s.nextLine());
            } catch (WrongInstructionException e){
                System.out.println("The instruction you gave is invalid");
                System.out.println("Please re-enter the instruction");
            } finally {
                System.out.println("Operating~");
            }
            System.out.println("Enter quit if you want to quit");
            if (s.nextLine().equals("quit")){
                break;

            }
        }
        queue.saveData();
        System.out.println("You successfully quit the app!");
    }

    private boolean hasFellows(String instruction) throws WrongInstructionException {
        if (instruction.equals("Yes")){
            return true;
        } else if (instruction.equals("No")){
            return false;
        } else throw new WrongInstructionException();
    }

    //MODIFY:this
    //EFFECT:if the customer is in the customers, print the position, otherwise generate a new position
    public void thisCustomer(Customer c, ListOfCustomer queue) {
        Scanner s = new Scanner(System.in);
        if (c.isIfReserved()) {
            System.out.println("Please enter the position of reserved customer:");
            c.setPosition(Integer.parseInt(s.nextLine()));
            System.out.println("Your reserved position has been saved!");
        } else if (queue.ifAlreadyInQueue(c)) {
            System.out.println("You are already in customers and ");
            System.out.println("Your current position in the customers is " + c.getPosition());
        } else {
            c.setPosition(generatePosition(queue.getCustomers().size()));
            System.out.println("Please wait! ");
            System.out.println("You position in the customers is " + c.getPosition());
        }

    }

    //REQUIRE:P greater or equal to 0 and less than the size of customers
    //MODIFY:field: Customer position
    //EFFECT:generate a position for new customer
    private static int generatePosition(int p) {
        p++;
        return p;
    }

    //Require: enter correct instructions
    //EFFECT:generate multiple functions
    public void functions(Customer c, ListOfCustomer queue, String function) throws WrongInstructionException {
        Scanner s = new Scanner(System.in);
        switch (function) {
            case "add":
                c.addCustomer(queue.getCustomers(), c);
                break;
            case "remove":
                queue.removeCustomer(c);
                break;
            case "reset":
                queue.resetQueue();
                break;
            case "search":
                do {
                    System.out.println("Please enter the name of the customer: ");
                    String name = s.nextLine();
                    try {
                        queue.searchCustomer(name);
                    } catch (UserNotInQueueException e) {
                        queue.setNotInTheQueue(true);
                        System.out.println("The customer you are searching is not in the customers.");
                        System.out.println("Please re-enter the name!");

                    } finally {
                        System.out.println("Operating~");
                    }
                } while (queue.isNotInTheQueue());

                break;
            case "pass":
                break;
            default:
                throw new WrongInstructionException();

        }

    }
}
