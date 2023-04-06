package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 테스트 케이스 개수 T가 주어지고 각 케이스마다 정수 A,B가 주어질 경우 A+B를 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/10950" />Baekjoon_10950 A+B-3</a>
 *
 */
public class LevelB {
    /**
     * 테스트 케이스 T 만큼 반복문을 실행한 후 A,B를 입력 받아 합을 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int A, B;
        int count = 0;

        while (count < T) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append(A + B);
            if (count < T - 1) {
                sb.append("\n");
            }
            count++;
        }
        br.close();
        System.out.println(sb);
    }
}
