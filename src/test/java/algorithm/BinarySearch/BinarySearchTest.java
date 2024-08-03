package algorithm.BinarySearch;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    void binarySearch() {

        int[] arr = {1, 13, 16, 23, 39, 45, 61, 84, 99, 120};
        int result = search(arr, 61);
        System.out.println("result = " + result);
    }

    static int search(int[] arr, int findKey) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == findKey) {
                return mid;
            }

            // 찾고자 하는 값이 중간 값보다 작은 경우 우측제거(중간 이후 제거)
            if (arr[mid] > findKey) {
                high = mid - 1;
            }

            // 찾고자 하는 값이 중간 값보다 클 경우 좌측제거(중간 이전 제거)
            if (arr[mid] < findKey) {
                low = mid + 1;
            }
        }
            // low > high 일 경우
            return -1;

    }
}
