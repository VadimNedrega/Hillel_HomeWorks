package vadim_nedrega.HW12_DataStreams.Examples.WriteSymbols;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteSymbols {
    public static void main(String[] args) {

        File file0 = new File("D:/Работа/file1.txt");
        File file1 = new File("D:/Работа/file2.txt");
        File file2 = new File("D:/Работа/file3.txt");

        String str = """
                Summer is out and it’s time to play.
                Have fun because summer is not here to stay.
                Jump in the pool and play all day.
                Or come on out and head for the bay.""";

        char[] buffer = new char[str.length()];
        str.getChars(0, str.length(), buffer, 0);

        try (FileWriter f0 = new FileWriter("vadim_nedrega/HW12_DataStreams/Examples/WriteSymbols/file1.txt");
             FileWriter f1 = new FileWriter("vadim_nedrega/HW12_DataStreams/Examples/WriteSymbols/file2.txt");
             FileWriter f2 = new FileWriter("vadim_nedrega/HW12_DataStreams/Examples/WriteSymbols/file3.txt")) {
            for (int i = 0; i < buffer.length; i += 2) {
                f0.write(buffer[i]);
            }

            f1.write(buffer);

            f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);
        } catch (IOException e) {
            System.out.println("Output error " + e);
        }
    }
}
