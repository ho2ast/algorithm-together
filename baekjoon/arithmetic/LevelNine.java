package baekjoon.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 세수 A, B, C가 주어졌을 때, 여러 나머지를 구하여 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/10430" />Backjoon_10430 나머지 계산</a>
 */
public class LevelNine {
    /**
     * <P> 세 수를 입력 받아 주어진 식으로 나머지를 계산
     * <P> 여러 줄로 출력을 하므로 {@link StringBuilder}를 이용하여 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append((a + b) % c).append("\n");
        sb.append(((a % c) + (b % c)) % c).append("\n");
        sb.append((a * b) % c).append("\n");
        sb.append(((a % c) * (b % c)) % c).append("\n");

        System.out.println(sb);
    }
}
