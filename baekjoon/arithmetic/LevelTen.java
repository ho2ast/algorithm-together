package baekjoon.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 세 자리 수 두 개가 주어질 때, 두 세자리 수 곱셈 과정의 값을 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/2588" />Backjoon_2588 세 자리 수 곱셈</a>
 */
public class LevelTen {
    /**
     * <p> 두 개의 세 자리수 중 첫 번째 수와 두 번째 수의 각 자리 수를 곱해준다.
     * <p> 일의 자리는 10으로 나눈 나머지.
     * <p> 십의 자리는 100으로 나눈 나머지를 10으로 나눈 몫.
     * <p> 백의 자리는 100으로 나눈 몫.
     * <p> 1. 첫 번째 수 * 두 번째 수 일의 자리
     * <p> 2. 첫 번째 수 * 두 번째 수 십의 자리
     * <p> 3. 첫 번째 수 * 두 번째 수 백의 자리
     * <p> 총 합의 경우 두 번째 수의 자리수 만큼 (1, 10, 100) 곱해준 후 더해준다.
     * <p> 두 번째 수를 String 으로 두고 각 자리수를 잘라서 사용해도 될듯.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int firstThreeDigit = Integer.parseInt(br.readLine());
        int secondThreeDigit = Integer.parseInt(br.readLine());
        br.close();

        int units = secondThreeDigit % 10;
        int tens = (secondThreeDigit % 100) / 10;
        int hundreds = secondThreeDigit / 100;

        int firstPosition = firstThreeDigit * units;
        int secondPosition = firstThreeDigit * tens;
        int thirdPosition = firstThreeDigit * hundreds;

        StringBuilder sb = new StringBuilder();
        sb.append(firstPosition).append("\n");
        sb.append(secondPosition).append("\n");
        sb.append(thirdPosition).append("\n");
        sb.append((firstPosition * 1) + (secondPosition * 10) + (thirdPosition * 100)).append("\n");

        System.out.println(sb);
    }
}
