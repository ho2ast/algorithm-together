package baekjoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p> 바구니가 주어지고 회전시킨 후 바구니 번호를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10812"/>Baekjoon_10812 바구니 순서 바꾸기</a></p>
 */
public class LevelD {
    /**
     * <p> begin <= mid <= end 이다. mid부터 end까지 그 후 다시 begin부터 mid까지 순서를 바꾼다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int[] bucketArr = new int[N];

        for (int i = 0; i < N; i++) {
            bucketArr[i] = i + 1;
        }

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = parseInt(st.nextToken());
            int j = parseInt(st.nextToken());
            int k = parseInt(st.nextToken());

            bucketArr = rotateArray(bucketArr, i, j, k, N);
        }

        for (int bucket : bucketArr) {
            sb.append(bucket).append(" ");
        }

        System.out.println(sb);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }

    private static int[] rotateArray(int[] arr, int i, int j, int k, int N) {
        int beginIdx = i - 1;
        int midIdx = k - 1;

        int[] copyArr = Arrays.copyOf(arr, N);

        for (int t = i - 1; t < j - k + i; t++) {
            copyArr[t] = arr[midIdx];
            midIdx++;
        }

        for (int t = j - k + i; t < j; t++) {
            copyArr[t] = arr[beginIdx];
            beginIdx++;
        }

        return copyArr;
    }
}
