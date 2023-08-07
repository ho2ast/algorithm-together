package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 자연수 N이 주어 졌을 때 N의 가장 작은 생성자를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2231"/>Baekjoon_2231 분해합</a>
 */
public class Level2 {
    /**
     * <p> 분해합의 공식을 이용하여 주어진 수 N이 되는 수를 찾아서 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        br.close();

        int start = N - String.valueOf(N).length() * 9;
        for (int i = start; i < N; i++) {
            int sum = 0;
            int number = i;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
