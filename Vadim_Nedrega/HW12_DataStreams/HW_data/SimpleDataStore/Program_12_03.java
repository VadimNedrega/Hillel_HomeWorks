package vadim_nedrega.HW12_DataStreams.HW_data.SimpleDataStore;

public class Program_12_03 {
    public static void main(String[] args) {
        Student1 student1 = new Student1("Max", "Power");
        Student1 student2;
        DataStoreSimple<Student1> dataStoreSimple = new FileStudentDataStoreSimple<>("D:\\Обучение IT\\Java Elementary\\Test\\", "Student.stud");

        dataStoreSimple.save(student1);

        student2 = dataStoreSimple.load();
        System.out.println(student2.getfName() + " " + student2.getlName());
        try {
            dataStoreSimple.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
