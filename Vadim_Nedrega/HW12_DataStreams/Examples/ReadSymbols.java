package vadim_nedrega.HW12_DataStreams.Examples;

import java.io.FileReader;
import java.io.IOException;

public class ReadSymbols {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("D:/Работа/NewFile1.txt")) {
            int a;

            while ((a = fileReader.read()) != -1) System.out.println((char) (a));
        } catch (IOException e) {
            System.out.println("Input-Output error " + e);
        }
    }
}
