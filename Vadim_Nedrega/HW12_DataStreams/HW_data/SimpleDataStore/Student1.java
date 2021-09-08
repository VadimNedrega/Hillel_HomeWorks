package vadim_nedrega.HW12_DataStreams.HW_data.SimpleDataStore;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student1 implements DataStoreObjectSimple {
    private String fName;
    private String lName;

    public Student1() {
    }

    public Student1(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }


    @Override
    public byte[] getData() {
        return String.format
                ("fName=%s; lName=%s;",
                        getfName(), getlName())
                .getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void setData(byte[] arr) {
        String data = new String(arr, StandardCharsets.UTF_8);
        String[] subData = data.split(";");
        List<String> studentData = new ArrayList<>(Arrays.asList(subData));
        fName = studentData.get(0).substring(6);
        lName = studentData.get(1).substring(7);
    }
}
