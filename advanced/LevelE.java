package advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 소문자로 이루어진 단어가 주어질 떄 팰린드롬인지 아닌지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10988"/>Baekjoon_10988 팰린드롬인지 확인하기</a></p>
 */
public class LevelE {
    /**
     * <p> 해당 문자열을 역순으로 바꾼 후 기본 문자열과 비교</p>
     * <p> loop를 돌며 역순으로 {@link StringBuilder#append(int)}를 활용하여 역순으로 해당 단어를 역순으로 만든다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int result = 0;
        String word = br.readLine();
        br.close();

        for (int i = word.length() - 1; i > -1; i--) {
            sb.append(word.charAt(i));
        }

        if (word.contentEquals(sb)) {
            result = 1;
        }

        System.out.println(result);
    }
}
