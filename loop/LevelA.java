package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> N을 입력받은 뒤, 구구단 N단을 형식에 맞춰 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/2739" />Baekjoon_2739 구구단</a>
 *
 */
public class LevelA {
    /**
     * <p> 양식에 맞추어 작성 한 뒤 {@link StringBuilder}의 append() 한 후 출력한다.
     * <p> 8단까지는 줄바꿈을 해줘야한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int i = 1;
        br.close();

        while (i < 10) {
            sb.append(N + " * " + i + " = " + N * i);
            if (i < 9) {
                sb.append("\n");
            }
            i++;
        }

        System.out.println(sb);
    }
}
