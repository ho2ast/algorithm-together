package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p> 소문자 단어가 주어질 때 조건에 맞게 정렬하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1181"/>Baekjoon_1181 단어 정렬</a>
 */
public class Level9 {
    /**
     * <p> 정렬은 조건은 길이가 짧은것부터, 길이가 같을 경우 사전순으로 정렬한다.
     * <p> {@link java.util.Comparator}를 사용하여 길이가 짧은순으로 정렬하고
     * <p> 길이가 같을 경우 {@link String#compareTo(String)}를 이용하여 알파벳 순으로 정렬한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });

        sb.append(arr[0]).append("\n");
        for (int i = 1; i < N; i++) {
            if (arr[i].equals(arr[i - 1])) {
                continue;
            }
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
