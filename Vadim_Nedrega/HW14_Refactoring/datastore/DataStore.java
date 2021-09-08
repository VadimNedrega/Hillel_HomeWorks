package vadim_nedrega.HW14_Refactoring.datastore;

import java.util.List;

public interface DataStore<T> extends AutoCloseable {
    void save(List<T> objList) throws DataStoreException;

    List<T> load() throws DataStoreException;
}