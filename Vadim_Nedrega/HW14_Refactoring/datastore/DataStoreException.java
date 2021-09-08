package vadim_nedrega.HW14_Refactoring.datastore;

public class DataStoreException extends Exception{
    public DataStoreException() {
    }

    public DataStoreException(String message) {
        super(message);
    }

    public DataStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataStoreException(Throwable cause) {
        super(cause);
    }
}
