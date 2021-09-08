import lombok.SneakyThrows;

import java.util.Arrays;

public class BaseSort implements SortIntInterface {
    private final int [] INPUT_ARRAY;

    public BaseSort(int[] INPUT_ARRAY) {
        this.INPUT_ARRAY = INPUT_ARRAY;
    }


    @SneakyThrows
    @Override
    public int [] sort(int [] arr) {
        if (arr == null) {
            throw new BasicSortExceptions("The element is null");
        }
        Arrays.sort(arr);
        return arr;
    }

}
