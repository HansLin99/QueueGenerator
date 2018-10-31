package FileReaderWriter;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class FileWriterUser1 {
    public void writeData(List<Customer> queue) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> lines = new ArrayList<>();
        PrintWriter writer = new PrintWriter("output");
        for (Customer c: queue){
            lines.add(c.getName() + " " + c.getPhoneNumber() + " " + c.getPosition());
        }
        for (String line : lines){
            writer.println(line);
        }
        writer.close();
    }
}
