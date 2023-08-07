package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 시험친 과목의 수와 점수가 주어질 때 정해진 공식으로 새로운 점수를 구한 후 평균을 구한다.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1546" />Baekjoon_1546 평균</a>
 */
public class LevelJ {
    /**
     * <p> 주어진 점수로 배열을 생성한 후 최댓값을 같이 구한다. </p>
     * <p> 주어진 공식으로 점수를 다시 계산 한 후 합계에 더해준다. 이때 합계 변수는 double로 만들어준다. </p>
     * <p> 이후 해당 합계로 평균을 구한다. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] scoreArr = new int[N];
        int maxScore = Integer.MIN_VALUE;
        double scoreSum = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int score = parseInt(st.nextToken());
            maxScore = Math.max(score, maxScore);
            scoreArr[i] = score;
            scoreSum += score;
        }

        System.out.println((scoreSum/maxScore*100) / N);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
