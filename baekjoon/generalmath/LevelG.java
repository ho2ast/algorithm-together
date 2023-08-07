package baekjoon.generalmath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 달팽이가 나뭇가지 정상까지 올라가는데 며칠이 걸리는지 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2869"/>Baekjoon_2869 달팽이는 올라가고 싶다</a></p>
 */
public class LevelG {
    /**
     * <p> 낮에는 A미터 올라가고, 밤에는 B미터 미끄러진다면 하루동안 올라가는 거리는 A-B이다.</p>
     * <p> 정상에 올라간 이후는 더이상 미끄러지지 않는다.</p>
     * <p> 따라서 올라간 횟수가 미끄러진 횟수보다 무조건 1회 많다. 이를 식으로 세워보면</p>
     * <p> Ax - B(x-1) = V 가 된다. 이를 정리하면 x = (V-B)/(A-B)가 된다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int A = parseInt(st.nextToken());
        int B = parseInt(st.nextToken());
        int V = parseInt(st.nextToken());

        double days = (double) (V - B) / (A - B);

        System.out.println((int) Math.ceil(days));
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}