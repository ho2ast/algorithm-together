package generalmath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 숫자가 적힌 육각형의 벌집이 주어질 때 중앙에서 주어진 번호까지 몇 개의 방을 지나야 하는지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2292"/>Baekjoon_2292 벌집</a></p>
 */
public class LevelE {
    /**
     * <p> 육각형 벌집 모양이므로 가장 중심을 기준으로 육각형의 갯수는 6의 배수로 늘어난다.</p>
     * <p> 1 </p>
     * <p> 2 ~ 7 </p>
     * <p> 8 ~ 19 </p>
     * <p> 20 ~ 37 </p>
     * <p> 벌집의 숫자도 각 단계 마다 6의 배수만큼 늘어난다. </p>
     * <p> loop와 index를 이용하여 각 단계의 최대값을 구한다. </p>
     * <p> 주어진 N이 각 단계 벌집 번호의 최대값 보다 작거나 같으면 </p>
     * <p> N이 해당 단계에 있는 벌집이고 이는 최대값을 구하기 위해 사용한 index이고 곧 최소 개수의 방이 된다. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int initNum = 1;
        int standard = 1;

        while (N > standard) {
            standard += initNum * 6;
            initNum++;
        }

        System.out.println(initNum);
    }
}
