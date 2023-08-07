package baekjoon.geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 가장 아래부분의 정사각형 개수가 주어질 때 도형의 둘레를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/15894"/>Baekjoon_15894 수학은 체육과목 입니다</a>
 */
public class Level4 {
    /**
     * <p> 한 변의 길이가 1인 정사각형이 탑처럼 쌓였을 때 둘레
     * <p> 높이는 가장 아래부분의 사각형 개수와 동일
     * <p> 길이가 1인 부분
     * <p> 가장 위 사각형의 윗변 - 1 * 1
     * <p> 가장 아래부분의 밑변 - 1 * n
     * <p> 좌측 및 우측 변 - 1 * 2n
     * <p> 길이가 0.5인 부분
     * <p> 사격형이 접하는 부분의 윗변 - 1 * (n - 1)
     * <p> 위의 공식을 모두 더하면 4n이다.
     * <p> n은 10억 이하이므로 n을 int형으로 변환할 경우 int형을 넘어서는 스택오버플로우가 발생할 수 있으므로 Long으로 변환 해야한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(4 * Long.parseLong(br.readLine()));
    }
}
