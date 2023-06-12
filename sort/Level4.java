package sort;

import java.io.*;

/**
 * <p> N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2751"/>Baekjoon_2751 수 정렬하기 2</a>
 */
public class Level4 {
    /**
     * <p> 시간 복잡도가 O(nlogn)인 정렬 알고리즘 MergeSort, QuickSort, HeapSort 를 이용하여 해결한다.
     * <p> MergeSort 의 경우 BottomUp방식을 이용한다.
     */
    static int[] tempArr;
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

//            mergeSort(arr, 0, arr.length - 1);
//            quickSort(arr, 0, arr.length - 1);
            heapSort(arr);

            for (int a : arr) {
                bw.write(a + "\n");
            }
            bw.flush();
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        tempArr = new int[arr.length];
        // 각 round 에서 비교하는 배열들의 개수가 1, 2, 4, 8 순으로 올라간다.
        for (int size = 1; size <= right; size += size) {
            for (int j = 0; j <= right - size; j += (2 * size)) {
                int low = j;
                int mid = j + size - 1;
                int high = Math.min(j + (2 * size) - 1, right);
                merge(arr, low, mid, high);
            }
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                tempArr[idx] = arr[l];
                l++;
            } else {
                tempArr[idx] = arr[r];
                r++;
            }
            idx++;
        }

        if (l > mid) {
            while (r <= right) {
                tempArr[idx] = arr[r];
                r++;
                idx++;
            }
        } else {
            while (l <= mid) {
                tempArr[idx] = arr[l];
                l++;
                idx++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tempArr[i];
        }
    }

    // 직접 구현한 QuickSort의 경우 random pivot을 사용하지 않으면 O(n^2) 걸린다고 하여 제외
//    private static void quickSort(int[] arr, int left, int right) {
//        int lo = left;
//        int hi = right;
//
//        if (left >= right) {
//            return;
//        }
//
//        int pivot = arr[(left + right) / 2];
//
//        while (lo < hi) {
//            while (arr[lo] < pivot) {
//                lo++;
//            }
//
//            while (arr[hi] > pivot) {
//                hi--;
//            }
//
//            if (lo > hi) {
//                break;
//            }
//
//            int temp = arr[lo];
//            arr[lo] = arr[hi];
//            arr[hi] = temp;
//
//            lo++;
//            hi--;
//        }
//
//        quickSort(arr, left, lo - 1);
//        quickSort(arr, lo, right);
//    }

    private static void heapSort(int[] arr) {
        int size = arr.length;
        if(size < 2) {
            return;
        }
        int parentIdx = (size - 2) / 2;

        for (int i = parentIdx; i > -1; i--) {
            heapify(arr, i, size - 1);
        }

        for (int i = size - 1; i > -1; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, i - 1);
        }
    }

    private static void heapify(int[] arr, int parentIdx, int lastIdx) {
            int leftChildIdx = (parentIdx * 2) + 1;
            int rightChildIdx = (parentIdx * 2) + 2;
            int largestIdx = parentIdx;

            if (leftChildIdx <= lastIdx && arr[leftChildIdx] > arr[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            if (rightChildIdx <= lastIdx && arr[rightChildIdx] > arr[largestIdx]) {
                largestIdx = rightChildIdx;
            }

            if (parentIdx != largestIdx) {
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[largestIdx];
                arr[largestIdx] = temp;
                heapify(arr, largestIdx, lastIdx);
            }

    }
}
