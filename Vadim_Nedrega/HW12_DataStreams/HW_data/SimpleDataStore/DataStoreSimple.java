package vadim_nedrega.HW12_DataStreams.HW_data.SimpleDataStore;

public interface DataStoreSimple<T extends DataStoreObjectSimple> extends AutoCloseable {
    void save(Student1 student1);

    Student1 load();
}
