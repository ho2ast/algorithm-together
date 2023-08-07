package baekjoon.factorandmultiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 주어진 수 N개 중에서 소수가 몇 개 인지 찾아서 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1978"/>Baekjoon_1978 소수 찾기</a></p>
 */
public class LevelD {
    /**
     * <p> 소수란 약수가 1과 자기 자신인 수를 의미한다.</p>
     * <p> 숫자 N이 주어질 때 1이 약수이면 다른 약수는 N/1이 된다.</p>
     * <p> 1부터 N까지 반복문을 돌면 나머지가 0인 경우를 통해 약수를 구할 수 있지만 </p>
     * <p> N의 제곱근까지만 반복문을 돌아도 약수를 구할 수 있다. 약수가 i이면 N/i도 약수이기 때문이다. </p>
     * <p> 이를 통해 1이상의 수에서 약수가 나올 경우 N은 소수가 아니라고 판단 할 수 있다. </p>
     */
    public static void main(String[] args) throws IOException {
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < N; i++) {
            int number = parseInt(st.nextToken());
            result += isPrimeNumber(number);
        }

        System.out.println(result);
    }

    private static int isPrimeNumber(int number) {
        if (number == 1) {
            return 0;
        }

        int result = 1;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0 && i != 1) {
                result = 0;
                break;
            }
        }

        return result;
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
