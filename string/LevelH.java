package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 문자열 S를 입력받은 후, 해당 문자열에 몇개의 단어가 있는지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1152"/>Baekjoon_1152 단어의 개수</a></p>
 */
public class LevelH {
    /**
     * <p> 문자열은 공백으로 시작하거나 끝날 수 있으므로 {@link String#trim()}을 이용하여 좌우 공백을 제거한다.</p>
     * <p> 공백으로 구분되어 있는 문자열이므로 {@link String#split(String)}을 이용하여 공백을 기준으로 문자열을 잘라 배열로 만든다.</p>
     * <p> 그 후 배열의 길이를 리턴한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        String S = br.readLine();
        br.close();

        if (!S.equals(" ")) {
            result = S.trim().split(" ").length;
        }

        System.out.println(result);
    }
}
