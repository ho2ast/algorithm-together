package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어질 때, 주어진 글자의 아스키 코드값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11654" />Baekjoon_11654 아스키 코드</a>
 */
public class LevelD {
    /**
     * 아스키 코드를 얻기 위해서는 주어진 글자를 char로 변환 후 int형으로 출력하면 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char s = br.readLine().charAt(0);
        br.close();

        System.out.println((int) s);
    }
}
