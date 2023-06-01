package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 정수 6개와 연립 방정식이 주어졌을 때 x, y를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/19532"/>Baekjoon_19532 수학은 비대면 강의입니다</a>
 */
public class Level3 {
    /**
     * <p> 연립방정식에서 x, y값을 구하기 위해서는 하나의 미지수를 없애야 한다. (가감법)
     * <p> x나 y에 대한 식으로 변경 후 대입하여 계산한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = ((c * e) - (b * f)) / ((a * e) - (b * d));
        int y = ((c * d) - (a * f)) / ((b * d) - (a * e));

        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}
