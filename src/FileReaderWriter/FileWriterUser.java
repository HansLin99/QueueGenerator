package FileReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUser {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("output", true);
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
