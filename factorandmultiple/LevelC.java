package factorandmultiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p> 숫자 n이 주어질 때, n이 완전수인지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/9506"/>Baekjoon_9506 약수들의 합</a></p>
 */
public class LevelC {
    /**
     * <p> 숫자 n의 완전수는 n을 제외한 약수들의 합이 n과 동일한 수 이다.</p>
     * <p> 따라서 약수를 구해 더 해주고 그 수가 n과 같을 경우 출력한다.</p>
     * <p> 약수는 어떤수로 나누었을 때 나머지가 0인 수를 의미한다.</p>
     * <p> 즉, 1부터 n까지 loop를 돌며 나머지가 0인 수를 구하면 된다.</p>
     * <p> 하지만 이 방법은 수가 커질수록 굉장히 많은 시간이 걸리게 된다.</p>
     * <p> 약수의 특징은 하나의 약수를 알면 다른 약수는 무조건 알 수 있다는 것이다.</p>
     * <p> 10의 약수는 1,2,5,10 인데 2를 구하면 5는 알 수 있다는 것이다. n이 주어지고 하나의 약수가 i면 나머지는 약수는 n/i가 되는 것이다.</p>
     * <p> 이러한 원리를 이용하면 i <= n/i 인 범위까지만 구하면 되는 이는 n의 제곱근이 되는 시점이다.</p>
     * <p> 이를 이용하여 문제를 해결한다.</p>
     * <p> 출력양식은 완전수일 때를 가정하여 {@link StringBuilder}를 이용하여 만들어 주고</p>
     * <p> 만약 조건에 맞지 않을 경우 완전수가 아닐 때의 출력 형식을 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = 0;
        while ((number = parseInt(br.readLine())) != -1) {
            sb.append(findPerfectNumber(number)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }

    private static String findPerfectNumber(int number) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> factorArr = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                factorArr.add(i);
                if (i != number / i) {
                    factorArr.add(number / i);
                }
            }
        }

        factorArr.sort(Integer::compareTo);
        factorArr.remove(factorArr.size() - 1);

        int sum = 0;
        sb.append(number).append(" = ");
        for (int i = 0; i < factorArr.size(); i++) {
            sum += factorArr.get(i);
            sb.append(factorArr.get(i));
            if (i != factorArr.size() - 1) {
                sb.append(" + ");
            }
        }

        if (sum != number) {
            sb.setLength(0);
            sb.append(number).append(" is NOT perfect.");
        }
        return String.valueOf(sb);
    }
}
