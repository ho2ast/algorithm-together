package baekjoon.geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 직사각형의 세로, 가로 길이가 정수 A, B로 주어질 때 직사각형의 넓이를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/27323"/>Baekjoon_27323 직사각형</a>
 */
public class Level1 {
    /**
     * <p> 직사각형의 넓이를 구하는 공식은 세로 * 가로 이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(A * B);
    }
}
