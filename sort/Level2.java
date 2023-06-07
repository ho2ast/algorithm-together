package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p> 5개 자연수가 주어질 때 평균과 중앙값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2587"/>Baekjoon_2587 대표값 2</a>
 */
public class Level2 {
    /**
     * <p> 평균값은 모든 수를 합한 후 개수로 나누면 되지만, 중앙값은 정렬 후 구해야 하므로
     * <p> 시간 복잡도가 O(n²)인 세가지 정렬 방법(버블, 선택, 삽입)을 이용하여 구한다.
     * <p> {@link java.util.List#sort(Comparator)}함수를 이용하면 간단하게 정렬할 수 있지만
     * <p> 각 정렬을 직접 구현하여 해결한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        br.close();

        insertionSort(arr);

        System.out.println(sum / arr.length);
        System.out.println(arr[arr.length / 2]);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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
}
