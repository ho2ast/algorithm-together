package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> String S와 정수 i가 주어질 때 S의 i번째 글자를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/27866" />Baekjoon_27866 문자와 문자열</a>
 */
public class LevelA {
    /**
     * <p> {@link String}의 charAt()함수를 사용하여 i번째(인데스이므로 i-1) 문자를 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int i = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(S.charAt(i-1));
    }
}
