package arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 세 수 A, B, C가 주어 질 때, 세 수의 합을 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/11382" />Backjoon_11382 세 수 덧셈</a>
 */
public class LevelEleven {
    /**
     * 각 수의 범위 (1 ≤ A, B, C ≤ 10^12)를 확인!!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(a + b + c);
    }
}
