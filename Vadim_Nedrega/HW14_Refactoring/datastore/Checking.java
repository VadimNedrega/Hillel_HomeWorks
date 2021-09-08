package vadim_nedrega.HW14_Refactoring.datastore;

import vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.DataInfo.DataInfoExceptions;

import java.io.File;

public class Checking<T> {
    private String dirPath;
    private Class<? extends T> clazz;
    private File file;
    private final String FILE_NAME = "SomeFile.json";

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public Checking(String dirPath, Class<? extends T> clazz) {
        this.dirPath = dirPath;
        this.clazz = clazz;
    }

    public Checking() {
    }

    protected String checkIfDirectory(String dirPath) {

            file = new File(dirPath);
            if (file.isDirectory()) {
                dirPath = dirPath  + "/" + FILE_NAME;
                file = new File(dirPath);
                return dirPath;
        } return dirPath;
    }

    protected Class<? extends T> checkClass (Class<? extends T> clazz) throws DataStoreException {
        if (clazz==null){
            throw new DataStoreException("Class is wrong. Please choose acceptable Class");
        } else return clazz;
    }
}
