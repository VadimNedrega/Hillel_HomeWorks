package vadim_nedrega.HW12_DataStreams.HW_data.DataImageStore;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ImageData implements DataStoreImageSimple {
    private String data;
    private int height;
    private int width;

    public String getData() {
        return data;
    }

    @Override
    public int getImageHeight() {
        return height;
    }

    @Override
    public int getImageWidth() {
        return width;
    }

    @Override
    public void setData(byte[] arr) {
        data = new String(arr, StandardCharsets.UTF_8);


        byte[] bytesWidth = new byte[4];
        System.arraycopy(arr, 16, bytesWidth, 0, 4);
        ByteBuffer wrappedWidth = ByteBuffer.wrap(bytesWidth);
        width = wrappedWidth.getInt();


        byte[] bytesHeight = new byte[4];
        System.arraycopy(arr, 20, bytesHeight, 0, 4);
        ByteBuffer wrappedHeight = ByteBuffer.wrap(bytesHeight);
        height = wrappedHeight.getInt();

    }
}
