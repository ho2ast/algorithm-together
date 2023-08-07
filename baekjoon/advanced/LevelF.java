package baekjoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p> 알파벳 대소문자로 이루어진 단어가 주어질 때 가장 많이 사용된 알파벳을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1157"/>Baekjoon_1157 단어 공부</a></p>
 */
public class LevelF {
    /**
     * <p> 대소문자를 구분하지 않기 때문에 {@link String#toUpperCase()}를 이용하여 대문자로 변경</p>
     * <p> 그 후 각 알파벳을 key로 하는 {@link java.util.Map}에 담에 횟수를 value로 저장한 후 가장 큰수를 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> alphabetMap = new HashMap<>();
        String result = "";
        String word = br.readLine().toUpperCase();
        int max = Integer.MIN_VALUE;
        int maxCount = 0;

        for (int i = 0; i < word.length(); i++) {
            String alphabet = String.valueOf(word.charAt(i));
            int count = alphabetMap.getOrDefault(alphabet, 0);
            alphabetMap.put(alphabet, ++count);
        }

        Set<String> keySet = alphabetMap.keySet();
        for (String key : keySet) {
            if (alphabetMap.get(key) > max) {
                max = alphabetMap.get(key);
                result = key;
            }
        }

        for (String key : keySet) {
            if (alphabetMap.get(key) == max) {
                maxCount++;
            }
        }

        if (maxCount == 1) {
            System.out.println(result);
        } else {
            System.out.println("?");
        }
    }
}
