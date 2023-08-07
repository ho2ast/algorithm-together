package baekjoon.factorandmultiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * <p> 정수 N이 주어질 때 N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11653"/>Baekjoon_11653 소인수분해</a></p>
 */
public class LevelF {
    /**
     * <p> 소인수분해란 자연수를 소인수들의 곱으로 나타내는 것이다. 소인수란 인수중 소수인 것을 의미한다.</p>
     * <p> 즉, N이 주어졌을 때 소수로 계속 나누어 나머지가 1이 될 때까지 while 문을 사용한다.</p>
     * <p> while 문 내부에서는 for 문 시작을 가장 작은 소수인 2부터 시작하도록 loop를 돌며 N을 소수로 나누었을 때 나머지가 0이 되는지 확인한다.</p>
     * <p> 0이 될 경우 N은 해당 수로 나눈 값으로 바꿔주고 해당 소수로 출력한다.</p>
     * <p> 여기서 혹시 i가 소수가 아닌 수 예를 들어 4가 되는 경우를 우려하는데 이는 2에서 이미 나누어 졌기 때문에 4로 나누어 떨어지는 경우는 </p>
     * <p> 절대로 발생하지 않고 다음 소수인 5로 넘어가게 된다. 이를 숙지 하고 문제를 풀도록 하자.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N = N / i;
            }
        }

        if (N != 1) {
            sb.append(N);
        }
        System.out.println(sb);
    }
}
