import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class BaseSortTest {
    @Mock
    private final int[] array = new int[] {23, 15, 46, Integer.MIN_VALUE, Integer.MAX_VALUE};
    private BaseSort testInstance;


    @Test
    void same() {
        testInstance = new BaseSort(array);
        assertEquals(testInstance.sort(array), array);
    }

    @Test
    void notTheSame() {
        testInstance = new BaseSort(array);
        assertNotEquals(testInstance.sort(array), new int[]{12, 45});
    }

    @Test
    void checkExceptions() {
        testInstance = new BaseSort(null);
       assertThrows(BasicSortExceptions.class, () -> testInstance.sort(null));
    }

    @Test
    void checkNotThrowExceptions() {
        testInstance = new BaseSort(array);
        assertDoesNotThrow(() -> testInstance.sort(array));
    }


    @Test
    void checkBorderConditions() {
        testInstance = new BaseSort(array);
        assertArrayEquals(testInstance.sort(array), new int[]{Integer.MIN_VALUE, 15, 23, 46, Integer.MAX_VALUE});
    }



}