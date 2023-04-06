package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> n이 주어졌을 때, 1부터 n까지 합을 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/8393" />Baekjoon_8393 합</a>
 */
public class LevelC {
    /**
     * <p> 1부터 n까지 반복문을 통해 합을 구해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        int n = Integer.parseInt(br.readLine());
        br.close();

        int sum = 0;
        while (i < n + 1) {
            sum += i;
            i++;
        }

        System.out.println(sum);
    }
}
