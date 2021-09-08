package vadim_nedrega.HW12_DataStreams.HW_data.DataImageStore;

import java.io.*;

public class FileDataStoreImage<T extends DataStoreImageSimple> implements DataStoreImage<ImageData> {
    private final String dirPath;
    private final String fileName;
    private final byte[] buffer = new byte[10000];
    private InputStream inputStream = null;

    public FileDataStoreImage(String dirPath, String fileName) {
        this.dirPath = dirPath;
        this.fileName = fileName;

    }

    @Override
    public void smallPartRead() {
        inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(dirPath + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert inputStream != null;
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ImageData load() {
        ImageData data = new ImageData();
        smallPartRead();
        data.setData(buffer);
        return data;
    }

    @Override
    public void close() throws Exception {
        if (inputStream != null) inputStream.close();
    }
}
