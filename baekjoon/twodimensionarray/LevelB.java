package baekjoon.twodimensionarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 9*9 행렬의 숫자가 주어질 때 최댓값과 몇 행 몇 열인지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2566"/>Baekjoon_2566 최댓값</a></p>
 */
public class LevelB {
    /**
     * <p> 9*9 행렬이 주어진다. 81길이의 배열을 생성 후 주어진 숫자를 넣으면서 최대값과 인덱스를 구한다.</p>
     * <p> 최종적으로 최댓값과 인덱스가 주어 졌을 때 9로 나눈 몫 + 1이 행이다.</p>
     * <p> 9 * (행 - 1) 값을 인덱스에서 뺀 후 ,몇 번째 열인지 구한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] numArr = new int[81];
        int index = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                numArr[index] = parseInt(st.nextToken());
                if (numArr[index] > max) {
                    max = numArr[index];
                    maxIndex = index;
                }
                index++;
            }
        }

        int row = (maxIndex / 9) + 1;
        int column = maxIndex - (9 * (row - 1)) + 1;
        sb.append(max).append("\n");
        sb.append(row).append(" ").append(column);

        System.out.println(sb);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
