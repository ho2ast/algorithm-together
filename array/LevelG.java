package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 1번부터 30번까지 번호가 주어질 때 없는 번호를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/5597" />Baekjoon_5597 과제 안 내신 분..?</a>
 */
public class LevelG {
    /**
     * <p> 길이가 30인 배열을 만든다. 그 후 28회의 loop 돌며 해당 번호의 순서에 값을 넣어 초기화 한다.
     * <p> 값이 들어가지 않은 인덱스의 값은 0이므로 값이 0인 인덱스의 번호를 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] numArr = new int[30];

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            numArr[num - 1] = num;
        }

        int num = 0;
        for (int i = 0; i < 30; i++) {
            if (numArr[i] == 0 && num == 0) {
                num = i + 1;
            } else if (numArr[i] == 0 && num != 0) {
                sb.append(Math.min(num, i + 1)).append("\n");
                sb.append(Math.max(num, i + 1));
                break;
            }
        }
        System.out.println(sb);
    }
}
