package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> 다이얼의 문자열이 주어질 때 해당 다이얼을 걸기 위해 필요한 시간을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/5622"/>Baekjoon_5622 다이얼</a></p>
 */
public class LevelJ {
    /**
     * <p> 각 알파벳을 거는데 소요되는 시간을 {@link java.util.Map}으로 저장해둔 후 해당 알파벳에 해당하는 시간을 더해준다.</p>
     * <p> 제출 답변에서 각 문자열의 아스키 코드를 구한 후 해당 범위의 아스키 코드에 해당하는 다이얼 번호에 대한 시간을 계산해주는 방법도 있음.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int takenSeconds = 0;
        Map<Character, Integer> seconds = new HashMap<>(){{
            put('A', 3);
            put('B', 3);
            put('C', 3);
            put('D', 4);
            put('E', 4);
            put('F', 4);
            put('G', 5);
            put('H', 5);
            put('I', 5);
            put('J', 6);
            put('K', 6);
            put('L', 6);
            put('M', 7);
            put('N', 7);
            put('O', 7);
            put('P', 8);
            put('Q', 8);
            put('R', 8);
            put('S', 8);
            put('T', 9);
            put('U', 9);
            put('V', 9);
            put('W', 10);
            put('X', 10);
            put('Y', 10);
            put('Z', 10);
        }};
        String word = br.readLine();
        br.close();

        for (int i = 0; i < word.length(); i++) {
            takenSeconds += seconds.get(word.charAt(i));
        }

        System.out.println(takenSeconds);
    }
}
