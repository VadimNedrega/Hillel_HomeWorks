package vadim_nedrega.HW12_DataStreams.Examples;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytes {
    public static void main(String[] args) {
        final String filePath = "D:/Работа/NewFile.txt";
        int[] data = {12, 11, 45, 13, 78};
        FileOutputStream myFile = null;
        try {
            myFile = new FileOutputStream(filePath, true);
            for (int someData : data) {
                myFile.write(someData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (myFile != null) myFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
