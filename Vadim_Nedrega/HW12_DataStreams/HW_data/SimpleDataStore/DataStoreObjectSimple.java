package vadim_nedrega.HW12_DataStreams.HW_data.SimpleDataStore;

public interface DataStoreObjectSimple extends Cloneable {
    byte[] getData();

    void setData(byte[] arr);
}
