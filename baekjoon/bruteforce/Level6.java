package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 옮겨야 할 설탕 무게 N이 주여 졌을 때 최소한의 봉지 개수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2839"/>Baekjoon_2839 설탕 배달</a>
 */
public class Level6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                result += N / 5;
                System.out.println(result);
                return;
            }

            if (N < 3) {
                System.out.println(-1);
                return;
            }

            N -= 3;
            result++;
        }

        System.out.println(result);
    }
}
