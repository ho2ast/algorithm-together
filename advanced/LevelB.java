package advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 체스 피스의 개수가 주어질 때 올바른 세트가 되기 위한 수를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/3003"/>Baekjoon_3003 킹, 퀸, 룩, 비숍, 나이트, 폰</a></p>
 */
public class LevelB {
    /**
     * <p> 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개가 올바른 세트이므로,</p>
     * <p> 주어진 피스의 값과 비교하여 필요한 피스를 가감한다.</p>
     * <p> 올바른 피스의 수를 원소로 가진 배열 생성, 주어진 피스도 배열로 생성 후 두 (올바른 피스-주어진 피스)를 리턴한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] rightPieceArr = {1, 1, 2, 2, 2, 8};
        String[] pieceArr = br.readLine().split(" ");

        for (int i = 0; i < rightPieceArr.length; i++) {
            sb.append(rightPieceArr[i] - Integer.parseInt(pieceArr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
