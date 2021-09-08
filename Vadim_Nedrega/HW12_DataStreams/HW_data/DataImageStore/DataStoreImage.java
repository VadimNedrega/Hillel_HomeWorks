package vadim_nedrega.HW12_DataStreams.HW_data.DataImageStore;

public interface DataStoreImage<T extends DataStoreImageSimple> extends AutoCloseable {
    ImageData load();

    void smallPartRead();
}
