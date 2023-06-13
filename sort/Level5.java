package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> N개의 수가 주어 졌을 때 이를 오름차순으로 정렬하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10989"/>Baekjoon_10989 수 정렬하기 3</a>
 */
public class Level5 {
    /**
     * <p> 이 문제는 counting sort 를 이용하여 문제를 해결해본다.
     * <p> 카운팅 정렬이란 숫자가 주어질 때 해당 숫자를 인덱스로 값으로 이용하여
     * <p> 해당 숫자가 나올 때 마다 +1을 해주는 방법을 이용한다.
     * <p> {@link String#repeat(int)} 해당 메서드는 파라미터 만큼 해당 문자열을 반복하는 메서드.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            if (count != 0) sb.append((i + "\n").repeat(count));
        }

        System.out.println(sb);
    }
}
