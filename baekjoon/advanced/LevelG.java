package baekjoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.StringTokenizer;

/**
 * <p> 학생들의 점수가 주어질 때, 평균을 넘는 비율을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/4344"/>Baekjoon_4344 평균은 넘겠지</a></p>
 */
public class LevelG {
    /**
     * <p> 테스트 게이스 C 만큼 loop를 돌며 학생의 수 N과 각 학생의 점수를 이용하여 평균을 구한다.</p>
     * <p> 그 후 평균 이상인 학생의 수를 이용하여 비율을 출력한다.</p>
     * <p> 평균과 평균 이상인 학생 수를 구하는 함수를 별도 구현한다.</p>
     * <p> 평균을 넘는 비율을 소숫점 3자리까지 표현해야 하므로 {@link String#format(String, Object...)}함수를 이용한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int C = parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            int[] scoreArr = transToIntArr(N, st);

            double scoreAvg = Arrays.stream(scoreArr).asDoubleStream().average().getAsDouble();
            sb.append(String.format("%.3f", (overAvg(scoreAvg, scoreArr) / (double) N) * 100)).append("%").append("\n");
        }

        System.out.println(sb);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }

    private static int[] transToIntArr(int N, StringTokenizer arrSt) {
        int[] scoreArr = new int[N];
        for (int i = 0; i < N; i++) {
            scoreArr[i] = parseInt(arrSt.nextToken());
        }

        return scoreArr;
    }

    private static int overAvg(double scoreAvg, int[] scoreArr) {
        int count = 0;
        for (int j : scoreArr) {
            if (j > scoreAvg) {
                count++;
            }
        }
        return count;
    }
}
