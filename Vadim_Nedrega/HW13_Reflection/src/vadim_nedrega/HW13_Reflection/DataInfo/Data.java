package vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.DataInfo;

import java.util.Map;

public interface Data<T> {
    String getName();

    Map<T, Integer> getData();

    void setData(Map<T, Integer> dataMap);

    void addData(Map<T, Integer> dataMap);

}
