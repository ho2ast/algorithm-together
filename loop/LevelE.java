package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 입력받은 정수 N이 있을 때, N 바이트 정수까지 저장할 수 있다고 생각하는 정수 자료형의 이름을 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/25314" />Baekjoon_25314 코딩은 체육과목 입니다</a>
 */
public class LevelE {
    /**
     * N은 4의 배수이므로 입력 받은 N을 4로 나눈 몫 만큼 long을 입력 해주면 된다.
     * {@link StringBuilder}의 append를 사용하여 long을 붙여준 후 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        br.close();

        int countLong = N / 4;

        for (int i = 0; i < countLong; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}
