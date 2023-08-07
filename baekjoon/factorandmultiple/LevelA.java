package baekjoon.factorandmultiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 두 수 A, B가 주어질 때 A가 B의 배수인지 약수인지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/5086"/>Baekjoon_5086 배수와 약수</a></p>
 */
public class LevelA {
    /**
     * <p> A % B == 0이면 A는 B의 배수</p>
     * <p> B % A == 0이면 A는 B의 약수</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) {
                break;
            }

            if (A % B == 0) {
                sb.append("multiple");
            } else if (B % A == 0) {
                sb.append("factor");
            } else {
                sb.append("neither");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
