package baekjoon.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> x, y 좌표를 입력 받아 그 점이 어느 사분면에 속하는지 출력 하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/14681" />Backjoon_14681 사분면 고르기</a>
 */
public class LevelD {
    /**
     * x, y 가 음수인지 양수인지 경우의 수를 구한다. (x, y != 0)
     * x>0, y>0 1사분면
     * x<0, y>0 2사분면
     * x<0, y<0 3사분면
     * x>0, y<0 4사분면
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder sb = new StringBuilder();

        if (x > 0 && y > 0) {
            sb.append(1);
        } else if (x < 0 && y > 0) {
            sb.append(2);
        } else if (x < 0 && y < 0) {
            sb.append(3);
        } else {
            sb.append(4);
        }

        System.out.println(sb);
    }
}
