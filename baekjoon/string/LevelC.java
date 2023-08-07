package baekjoon.string;

import java.io.*;

/**
 * <p> 문자열이 주어질 때 첫 글자와 마지막 글자를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/9086" />Baekjoon_9086 문자열</a>
 */
public class LevelC {
    /**
     * <p> 주어진 테스트 케이스 T 만큼 loop를 돌며 주어진 String의 첫글자와 마지막 글자를 출력한다.</p>
     * <p> {@link String}의 charAt() 함수를 이용하여 문자열을 출력하고,</p>
     * <p> 첫글자의 index는 0, 마지막 인덱스는 문자열 길이 length()-1을 이용하여 구한다.</p>
     * <p> 출력은 {@link StringBuilder}의 append() 함수를 이용하여 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length()-1));
            if (i < T - 1) {
                sb.append("\n");
            }
        }
        br.close();

        System.out.println(sb);
    }
}
