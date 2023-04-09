package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 정수 A, B가 주어 질 때 A+B 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/10951" />Baekjoon_10951 A+B - 4</a>
 */
public class LevelL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = "";

        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(A + B).append("\n");
        }
        System.out.println(sb);
    }
}
