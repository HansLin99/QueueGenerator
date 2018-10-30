package FileReaderWriter;

import CustomerData.Customer;
import CustomerData.ListOfCustomer;
import CustomerData.RegularCustomer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderUser1 {
    public ListOfCustomer readData() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("output"));
        ListOfCustomer q = new ListOfCustomer();
        for (String line : lines){
            Customer c = new RegularCustomer();
            ArrayList<String> partsOfLine = splitOnSpace(line);
            c.name = partsOfLine.get(0);
            c.phoneNumber = partsOfLine.get(1);
            try {
                c.position = (Integer.parseInt(partsOfLine.get(2)));
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Your save file have a invalid position.");
            }
            q.addCustomer(c);

        }
        return q;
    }

    private static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split("\\s+");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
