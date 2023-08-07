package baekjoon.generalmath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 분수들이 지그재그 순서대로 나올 때 X번째 분수를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1193"/>Baekjoon_1193 분수찾기</a></p>
 */
public class LevelF {
    /**
     * <p> 주어진 표를 45도 기울여 피라미드 모양으로 보면 </p>
     * <p> 가장 첫 번째 라인 1/1부터 시작하여 N번째 라인 왼쪽 기준 N/1, N-1/2, N-2/3 식으로 구성된다. </p>
     * <p> 각 라인의 분수 개수도 1, 2, 3, 4로 1씩 증가하는 등차수열 형태이다. </p>
     * <p> 또한 지그재그로 이어지므로 각 라인의 시작 분수 또한 다르다. </p>
     * <p> 홀수 라인은 왼쪽부터 시작 짝수라인은 오른쪽부터 시작한다. </p>
     * <p> 따라서 X가 주어질 때 몇 번째 라인인지 찾고 해당 라인의 몇번째 인지 분수 값을 구한다. </p>
     * <p> 몇번 째 라인인지 찾기 위해서는 반복을 통해 1번째 줄 부터 N번째 줄 까지의 누적 합을 구해 X와 비교한다. </p>
     * <p> 누적 합이 X보다 크면 X는 N째 라인에 속한다. </p>
     * <p> 그 줄의 볓번째 인지는 X에서 속한 라인 이전 라인까지의 누적합을 빼면된다. </p>
     * <p> 분모와 분자는 좌측 기준으로 구한다. </p>
     * <p> 분수의 규칙에 따라 분자는 1부터 1씩 늘어나므로 라인의 몇 번째인지 구한 값을 사용한다. </p>
     * <p> 분모는 1씩 줄어들기 때문에 N - (볓 번째인지 값 - 1)으로 구할 수 있다. </p>
     * <p> 마지막으로 각 줄의 분수는 대칭으로 이루어져 있다. </p>
     * <p> 따라서 N이 짝수냐 홀수냐 따라서 위에서 구한 분자, 분모값을 위치만 바꾸어 표현하면 된다. </p>
     * <p> 짝수일 경우 우측부터 시작하므로 분모, 분자값을 바꾸어서 출력하고, </p>
     * <p> 홀수일 경우 좌측부터 시작하므로 그대로 출력하면 된다. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int numerator = 0;
        int denominator = 0;
        int X = Integer.parseInt(br.readLine());
        br.close();

        int index = 0;
        int sum = 0;

        while (X > sum) {
            index++;
            sum += index;
        }
        sum -= index;

        int number = X - sum;
        numerator = index - (number - 1);
        denominator = number;

        if (index % 2 == 0) {
            sb.append(denominator).append("/").append(numerator);
        } else {
            sb.append(numerator).append("/").append(denominator);
        }

        System.out.println(sb);
    }
}
