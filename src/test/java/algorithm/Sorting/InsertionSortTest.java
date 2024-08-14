package algorithm.Sorting;

import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    void sortByInsertionSort() {

        int[] arr = new int[5];

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }
}
