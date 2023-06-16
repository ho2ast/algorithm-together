package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> N개의 수가 주어 졌을 때 이를 내림차순으로 정렬하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1427"/>Baekjoon_1427 소트인사이드</a>
 */
public class Level6 {
    /**
     * <p> 카운팅 정렬을 이용하여 내림차순으로 정렬을 한다.
     * <p> N의 자연수로 주어지므로 각 자리수의 숫자를 인덱스로 하여 값을 1씩 증가 시킨 후 출력한다.
     * <p> 출력은 {@link String#repeat(int)}을 이용하여 해당 숫자를 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        int[] arr = new int[10];

        for (int i = 0; i < N.length(); i++) {
            arr[N.charAt(i) - 48] += 1;
        }

        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] != 0) sb.append((String.valueOf(i)).repeat(arr[i]));
        }

        System.out.println(sb);
    }
}
