package advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 단어가 주어졌을 때 크로아티아 알파벳 몇개로 이루저 져 있는지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2941"/>Baekjoon_2941 크로아티아 알파벳</a></p>
 */
public class LevelH {
    /**
     * <p> 크로아티아 알파벳으로 주어진 문자열을 배열로 저장한다.</p>
     * <p> 그 후 해당 배열의 길이 만큼 loop를 돌며 {@link String#contains}를 활용하여 해당 크로아티아 문자열이 있을 경우</p>
     * <p> {@link String#replaceFirst}을 사용하여 제거 한다. (같은 알파벳이 여러번 있을 경우를 대비해야 하므로)</p>
     * <p> {@link String#replaceFirst} 사용시 제거 후의 문자열이 새로운 알파벳이 될 수 있으므로 공백으로 대체한다.</p>
     * <p> 그 후 크로아티아 알파벳을 제거 한 후 남은 공백을 모두 제거 후 남은 문자열의 길이와 함께 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int result = 0;
        br.close();

        String[] croatiaAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String alphabet : croatiaAlphabet) {
            while (word.contains(alphabet)) {
                word = word.replaceFirst(alphabet, " ");
                result++;
            }
        }

        word = word.replace(" ", "");
        System.out.println(result + word.length());
    }
}
