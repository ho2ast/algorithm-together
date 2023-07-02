package setandmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * <p> 도감에 있는 포켓몬이 주어지고 포켓몬의 이름이나 번호가 주어질 때 해당 포켓몬의 번호 또는 이름을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1620"/>Baekjoon_1620 나는야 포켓몬 마스터 이다솜/a>
 */
public class Level4 {
    /**
     * <p> 포켓몬의 이름이 순서대로 주어 지기 때문에 해당 포켓몬의 이름을 {@link Map}의 key로 번호를 value값으로 저장한다.
     * <p> 문제로 숫자가 주어지면 Map의 value로 key를 구해야 하는데 이때 시간 초과가 될 수 있다.
     * <p> 따라서 배열을 사용하여 포켓몬 번호를 인덱스로 하여 배열에 포켓몬 이름을 저장한다.
     * <p> 이후 주어진 문제에 대해 이름이 주어질 경우 Map에서 해당 포켓몬의 value를
     * <p> 번호가 주어질 경우 key를 인덱스로 하여 배열의 이름을 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> pocketmonMap = new HashMap<>();
        String[] pocketmonArr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String pocketmonName = br.readLine();
            pocketmonMap.put(pocketmonName, i);
            pocketmonArr[i] = pocketmonName;
        }

        for (int i = 0; i < M; i++) {
            String token = br.readLine();
            try {
                int num = Integer.parseInt(token);
                String pocketmonName = pocketmonArr[num];
                sb.append(pocketmonName).append("\n");
            } catch (Exception e) {
                sb.append(pocketmonMap.get(token)).append("\n");
            }
        }

        br.close();
        System.out.println(sb);
    }
}
