package vadim_nedrega.HW17_XML.XMLDataStore;

import java.util.List;

public interface DataStore<T> {
    List<T> load();

    void save(List<T> itemList);
}
