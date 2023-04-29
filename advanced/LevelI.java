package advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> 소문자로 이루어진 단어들이 주어 질 때 그룹 단어의 개수를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1316"/>Baekjoon_1316 그룹 단어 체커</a></p>
 */
public class LevelI {
    /**
     * <p> while loop를 돌며 주어진 단어의 연속된 글자인지 체크를 한다.</p>
     * <p> {@link String#startsWith}메서드를 활용하여 이전 글자와 동일 할 경우 해당 알파벳을 지우고 해당 알파벳을 {@link java.util.Map}에 저장한다.</p>
     * <p> 새로운 알파벳으로 시작할 경우 해당 알파벳이 map에 저장되어 있는지 확인 후 위의 과정을 반복한다.</p>
     * <p> 새로운 알파벳으로 바뀌었지만 map에 저장되어 있을 경우 그룹단어가 아니라고 판단한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            result += groupWordChecker(br.readLine());
        }

        System.out.println(result);
    }

    public static int groupWordChecker(String word) {
        int isGroupWord = 1;
        Map<String, Boolean> alphabetChecker = new HashMap<>();
        String checkedAlphabet = String.valueOf(word.charAt(0));
        alphabetChecker.put(checkedAlphabet, true);
        while (word.length() > 0) {
            if (word.startsWith(checkedAlphabet)) {
                word = word.substring(1);
            } else {
                checkedAlphabet = String.valueOf(word.charAt(0));
                if (alphabetChecker.containsKey(checkedAlphabet)) {
                    isGroupWord = 0;
                    break;
                } else {
                    alphabetChecker.put(checkedAlphabet, true);
                    word = word.substring(1);
                }
            }
        }

        return isGroupWord;
    }
}
