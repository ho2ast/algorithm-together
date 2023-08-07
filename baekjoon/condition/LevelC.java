package baekjoon.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/2753" />Backjoon_2753 윤년</a>
 */
public class LevelC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        br.close();

        int isLeapYear = 0;
        if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
            isLeapYear = 1;
        }

        System.out.println(isLeapYear);
    }
}
