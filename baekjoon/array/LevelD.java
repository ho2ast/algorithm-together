package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 9개의 자연수가 주어질 때 최댓값과 몇 번째 수인지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2562" />Baekjoon_2562 최댓값</a>
 */
public class LevelD {
    /**
     * <p> 주어진 수를 배열로 만들고 loop를 돌면서 최댓값을 찾고 해당 값의 index를 구한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int index = 0;
        int[] numArr = new int[9];

        for (int i = 0; i < 9; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for (int i = 0; i < 9; i++) {
            if (numArr[i] > max) {
                max = numArr[i];
                index = i + 1;
            }
        }

        sb.append(max).append("\n").append(index);
        System.out.println(sb);
    }
}
