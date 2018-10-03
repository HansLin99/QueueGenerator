package FileReaderWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileReaderUser {
    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<>();
        try {
            java.io.FileReader reader = new java.io.FileReader("input");
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    }


