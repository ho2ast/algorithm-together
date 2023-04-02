package arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 이미 존재하는 아이디가 주어질 때, "id??!"를 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/10926" />??!</a>
 */
public class LevelSeven {
    /**
     * <p> 주어진 String 아이디 뒤에 ??!를 append 하여 출력
     * <p> String 을 이어주는 + 연산자를 사용해도 되지만 {@link StringBuilder}의 append() 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        br.close();

        sb.append(br.readLine()).append("??!");
        System.out.println(sb);
    }
}
