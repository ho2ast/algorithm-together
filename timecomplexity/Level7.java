package timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 주어진 함수와 양의 정수가 주어질 경우 O-표기법을 만족하는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24313"/>Baekjoon_24313 점근적 표기 1</a>
 */
public class Level7 {
    /**
     * <p> 함수 f(n) = a<sub>1</sub>n + a<sub>0</sub>이 있을 때
     * <p> n >= n<sub>0</sub>에 대하여 fn <= c * g(n)을 만족 해야한다.
     * <p> 여기서 O(g(n))은 O(n)으로 나타낼 수 있기 때문에 g(n) = n으로 볼 수 있다.
     * <p> 위의 식을 정리해보면 a<sub>1</sub>n + a<sub>0</sub> <= c * n이다.
     * <p> n >= n<sub>0</sub>이므로 n<sub>0</sub>이 최소 값이므로 대입하여 계산한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        br.close();

        if (a1 * n0 + a0 <= c * n0 && a1 <= c) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
