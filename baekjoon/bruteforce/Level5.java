package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 자연수 N이 주어졌을 때 N번째 종말의 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1436"/>Baekjoon_1436 영화감독 숌</a>
 */
public class Level5 {
    /**
     * <p> 반복문을 돌며 666이 연속으로 나온 경우 cnt를 해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        br.close();

        int i = 1;
        int startNum = 666;

        while (i != N) {
            startNum++;
            if (String.valueOf(startNum).contains("666")) {
                i++;
            }
        }

        System.out.println(startNum);
    }
}
