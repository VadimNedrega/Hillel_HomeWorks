package vadim_nedrega.HW12_DataStreams.Examples;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingBytes {
    public static void main(String[] args) {
        final String filePath = "D:/Работа/ТК перемещение камня-известняка 1.doc";
        BufferedInputStream bufferedInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            while (true) {
                int byteValue = bufferedInputStream.read();
                System.out.println("Byte Value: " + byteValue);
                if (byteValue == -1) break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) bufferedInputStream.close();
                if (fileInputStream != null) fileInputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
