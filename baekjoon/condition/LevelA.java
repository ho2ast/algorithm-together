package baekjoon.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/1330" />Backjoon_1330 두 수 비교하기</a>
 */
public class LevelA {
    /**
     * <p> 조건문을 사용하여 두 수를 비교한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String result = "";
        if (a > b) {
            result = ">";
        } else if (a < b) {
            result = "<";
        } else {
            result = "==";
        }

        System.out.println(result);
    }
}
