package vadim_nedrega.HW12_DataStreams.HW_data.DataImageStore;

public interface DataStoreImageSimple extends Cloneable {
    int getImageHeight();

    int getImageWidth();

    void setData(byte[] arr);
}
