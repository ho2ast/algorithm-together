package twodimensionarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 다섯줄의 단어가 주어 질 때, 해당 단어를 세로로 읽어서 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10798"/>Baekjoon_10798 세로읽기</a></p>
 */
public class LevelC {
    /**
     * <p> 단어들은 5줄이고 각 줄 마다 최대 15개의 글자가 주어지므로 5*15의 2차원 배열을 만든다. </p>
     * <p> 그 후 loop를 통해 각 행의 첫 번째 열, 두 번째 열 등을 출력한다. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[][] matrix = new String[5][15];

        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            int index = 0;
            for (int j = 0; j < word.length(); j++) {
                matrix[i][j] = String.valueOf(word.charAt(j));
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[j][i] != null) {
                    sb.append(matrix[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}
