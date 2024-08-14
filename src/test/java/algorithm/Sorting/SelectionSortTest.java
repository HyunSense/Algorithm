package algorithm.Sorting;

import org.junit.jupiter.api.Test;

public class SelectionSortTest {

    public static void swap(int[] arr, int idx1, int idx2) {

        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

    }

    @Test
    void sortBySelectionSort() {

        int[] arr = new int[5];

        // {2, 5, 1, 3, 4}
        // i = 0, j = 1 일때,
        // minIdx = 0
        // arr[1] < arr[0] false
        // i = 0, j = 2 일때
        // minIdx = 0
        // arr[2] < arr[0] -> 1 < 2 true
        // minIdx = 2
        // i = 0, j = 3 일때
        // minIdx = 2
        // arr[3] < arr[2] -> 3 < 1 false
        // i = 0, j = 4 일때
        // minIdx = 2
        // arr[4] < arr[2] -> 4 < 1 false
        // swap -> arr[0] 과 arr[2] 교체 -> {1, 5, 2, 3, 4}

        // i = 1, j = 2 일때,
        // minIdx = 1
        // arr[2] < arr[1] -> 2 < 5 true
        // minIdx = 2
        // i = 1, j = 3 일때,
        // arr[3] < arr[2] -> 3 < 2 false
        // i = 1, j = 4 일때,
        // arr[4] < arr[2] -> 4 < 2 false
        // swap -> arr[1] 과 arr[2] 교체 -> {1, 2, 5, 3, 4}

        // i = 2, j = 3 일때,
        // minIdx = 2
        // arr[3] < arr[2] -> 3 < 5 true
        // minIdx = 3
        // i = 2, j = 4 일때
        // arr[4] < arr[3] -> 4 < 3 false
        // swap -> arr[2] 와 arr[3] 교체 -> {1, 2, 3, 5, 4}

        // i = 3, j = 4 일때,
        // minIdx = 3
        // arr[4] < arr[3] -> 4 < 5 true
        // minIdx = 4
        // swap -> arr[3] 과 arr[4] 교체 -> {1, 2, 3, 4, 5}

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

}
