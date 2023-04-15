package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> String S가 주어질 때 S의 길이를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2743" />Baekjoon_2743 단어 길이 재기</a>
 */
public class LevelB {
    /**
     * {@link String}의 length()함수를 사용하여 문자열 길이를 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        br.close();
        System.out.println(S.length());

    }
}
