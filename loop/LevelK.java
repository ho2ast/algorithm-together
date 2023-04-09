package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 정수 A, B가 주어 질 때 A+B 출력하세요. 마지막에는 0이 두개가 주어진다.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/10952" />Baekjoon_10952 A+B - 5</a>
 */
public class LevelK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();;
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) {
                break;
            }
            sb.append(A + B);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
