package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2750"/>Baekjoon_2750 수 정렬하기</a>
 */
public class Level1 {
    /**
     * <p> 여기서는 시간 복잡도가 O(n²)인 정렬 알고리즘을 사용하여 문제를 해결할 것이다.
     * <p> 버블정렬, 선택정렬, 삽입정렬 세가지 모두 사용하여 문제를 푼다.
     * <ol>
     *     <li>버블정렬</li>
     *     <li>선택정렬</li>
     *     <li>삽입정렬</li>
     * </ol>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(br.readLine());
        }

        insertionSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }

    public static void bubbleSort(int[] arr) {
        // 전체 라운드는 배열길이 - 1
        // 각 라운드별 비교횟수는 배열기링 - 라운드
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] - arr[j + 1] > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;

            while (j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = target;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
