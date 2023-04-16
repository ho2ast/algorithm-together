package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <p> 소문자로 이루어진 단어 S가 주어질 때, 알파벳에 대해 S포함된 경우 처음 등장하는 위치를 포함되어 있지 않으면 -1을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10809" />Baekjoon_10809 알파벳 찾기</a>
 */
public class LevelF {
    /**
     * <p> 알파벳의 아스키 코드를 이용한다.</p>
     * <p> 알파벳 소문자의 아스키 코드는 97번부터 122번 까지이다.</p>
     * <p> 주어진 문자열의 길이만큼 loop를 돌며 {@link String}의 charAt()을 이용하여</p>
     * <p> char형을 구한 뒤 int형으로 변환하여 아스키 코드를 구한다.</p>
     * <p> int 배열을 알파벳 길이 만큼 생성 한 후 구해준 아스키 코드에 -97을 한 후 char 위치한 인덱스 i값을 저장한다.</p>
     * <p> int 배열을 생성해준 후 -1로 초기화를 해준다. 반복문을 사용하거나, {@link Arrays}의 메소드를 이용한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphabetArr = new int[26];
        String s = br.readLine();
        br.close();

        for (int i = 0; i < alphabetArr.length; i++) {
            alphabetArr[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int asciiCode = s.charAt(i);
            if (alphabetArr[asciiCode - 97] == -1) {
                alphabetArr[asciiCode - 97] = i;
            } else {
                continue;
            }
        }

        for (int j : alphabetArr) {
            sb.append(j).append(" ");
        }

        System.out.println(sb);
    }
}
