package baekjoon.generalmath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 주어진 정사각형에서 규칙에 맞게 점을 추가했을 때 점이 몇개 인지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2903"/>Baekjoon_2903 중앙 이동 알고리즘</a></p>
 */
public class LevelD {
    /**
     * <p> 규칙으로 점은 각 변의 중앙 그리고 정사각형의 중심에 추가한다.</p>
     * <p> 과정이 반복 됨에 따라 한변의 점의 수는 2의 배수로 늘어난다.</p>
     * <p> 0번 - 점 2개</p>
     * <p> 1번 - 점 3개</p>
     * <p> 2번 - 점 5개</p>
     * <p> 3번 - 점 9개</p>
     * <p> 2<sup>n</sup> + 1 의 점이 생기게 된다.</p>
     * <p> 그리고 n번 실행되면 2<sup>n</sup> + 1개의 변이 생기므로 </p>
     * <p> 따라서 (2<sup>n</sup> + 1)<sup>2</sup>개의 점을 저장하면 된다. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        br.close();

        int dotCountOfLine = (int) Math.pow(Math.pow(2, count) + 1, 2);

        System.out.println(dotCountOfLine);
    }
}
