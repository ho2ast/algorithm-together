package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 입력으로 주어진 문자열을 그대로 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11718"/>Baekjoon_11718 그대로 출력하기</a></p>
 */
public class LevelK {
    /**
     * <p> 주어진 문자열을 그대로 출력한다. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S;

        while ((S = br.readLine()) != null) {
            System.out.println(S);
        }
        br.close();
    }
}
