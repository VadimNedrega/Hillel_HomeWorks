package vadim_nedrega.HW12_DataStreams.HW_data.SimpleDataStore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileStudentDataStoreSimple<T extends DataStoreObjectSimple> implements DataStoreSimple<Student1> {
    private final String dirPath;
    private final String fileName;
    private InputStream inputStream;
    private OutputStream outputStream;

    public FileStudentDataStoreSimple(String dirPath, String fileName) {
        this.dirPath = dirPath;
        this.fileName = fileName;
    }

    @Override
    public void save(Student1 student1) {
        outputStream = null;
        try {
            outputStream = new FileOutputStream(dirPath + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert outputStream != null;
            outputStream.write(student1.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student1 load() {
        Student1 student1 = new Student1();
        try {
            inputStream = new BufferedInputStream(new FileInputStream(dirPath + fileName));
            byte[] buffer = Files.readAllBytes(Path.of(dirPath + fileName));
            student1.setData(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student1;
    }

    @Override
    public void close() throws Exception {
        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
    }
}
