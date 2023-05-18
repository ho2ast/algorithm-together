package datastructure.sort;

public class MergeSort {
    /**
     * <p> 주어진 리스트를 절반으로 분할하여 부분리스트로 나눈다.
     * <p> 부분리스트의 길이가 1일 될 때까지 반복한다.
     * <p> 인접한 부분 리스트끼리 정렬하여 합친다.
     * <p> 비교하는 부분리스트의 길이는 1 -> 2 -> 4 -> 8... 식으로 늘어나게 된다.
     */
    private static int[] tempArr;

    public static void main(String[] args) {
        int[] arr = {7, 4, 3, 2, 5, 1, 6, 8};
        tempArr = new int[arr.length];
//        mergeSort_topDown(arr, 0, arr.length - 1);
        mergeSort_bottomUp(arr, 0, arr.length - 1);
    }

    private static void mergeSort_bottomUp(int[] arr, int left, int right) {
        for (int size = 1; size <= right; size += size) {
            for (int l = 0; l <= right - size; l += (2 * size)) {
                int start = l;
                int mid = l + size - 1;
                int end = Math.min(l + (2 * size) - 1, right);
                merge(arr, start, mid, end);
            }
        }
    }

    // Top-Down 방식
    private static void mergeSort_topDown(int[] arr, int left, int right) {
        if(left == right) return;

        int mid = (left + right) / 2;    // 절반 위치

        mergeSort_topDown(arr, left, mid);        // 절반 중 왼쪽 부분리스트(left ~ mid)
        mergeSort_topDown(arr, mid + 1, right);    // 절반 중 오른쪽 부분리스트(mid+1 ~ right)

        merge(arr, left, mid, right);        // 병합작업
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tempArr[idx] = arr[l];
                idx++;
                l++;
            } else {
                tempArr[idx] = arr[r];
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while (r <= right) {
                tempArr[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                tempArr[idx] = arr[l];
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tempArr[i];
        }
    }
}
