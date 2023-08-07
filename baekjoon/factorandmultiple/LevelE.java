package baekjoon.factorandmultiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 자연수 M과 N이 주어질 때, 그 사이에 있는 소수들의 합과 최솟값을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2581"/>Baekjoon_2581 소수</a></p>
 */
public class LevelE {
    /**
     * <p> 소수는 1과 자기자신만을 약수로 가지는 수 이다. </p>
     * <p> 즉, 약수의 개수가 2개인 수라고 할 수 있다. </p>
     * <p> 약수가 2개인 수를 찾고, 합을 구한다. 최솟값은 0인 변수에 값을 최초 할당 하면 최솟값이 된다. </p>
     * <p> 에라토스 테네스의 체 방법도 이용하여 풀어보도록 하자. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        br.close();

        boolean[] prime = getPrimeNumber(end);

        int min = 0;
        int sum = 0;

//        for (int i = start; i <= end; i++) {
//            if (isPrimeNumber(i)) {
//                if (min == 0) {
//                    min = i;
//                }
//                sum += i;
//            }
//        }

        // 에라토스테네스의 체 이용
        for (int i = start; i <= end; i++) {
            if (!prime[i]) {
                if (min == 0) {
                    min = i;
                }
                sum += i;
            }
        }


        if (sum == 0) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(min);
        }

        System.out.println(sb);
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }

        boolean result = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    // 에라토스테네스의 체
    private static boolean[] getPrimeNumber(int number) {
        boolean[] prime = new boolean[number + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        return prime;
    }
}
