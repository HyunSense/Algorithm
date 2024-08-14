package algorithm.Sorting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BubbleSortTest {

    public static void swap(int[] arr, int idx1, int idx2) {

        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

    }

    @Test
    void sortByBubbleSort() {
        // 암기
        // i < arr.length - 1
        // j < arr.length - i - 1
        // j 와 j + 1 을 비교
        int[] arr = new int[5];
        // {5, 4, 3, 2, 1}
        // i = 0, j < 4
        // {4, 5, 3, 2, 1} -> {4, 3, 5, 2, 1} -> {4, 3, 2, 5, 1} -> {4, 3, 2, 1, 5}
        // i = 1, j < 3
        // {3, 4, 2, 1, 5} -> {3, 2, 4, 1, 5} -> {3, 2, 1, 4, 5}
        // i = 2, j < 2
        // {2, 3, 1, 4, 5} -> {2, 1, 3, 4, 5}
        // i = 3, j < 1
        // {1, 2, 3, 4, 5}
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

}
