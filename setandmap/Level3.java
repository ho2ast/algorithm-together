package setandmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * <p> 직원들의 출퇴근 정보를 보고 회사에 남아 있는 직원을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/7785"/>Baekjoon_7785 회사에 있는 사람</a>
 */
public class Level3 {
    /**
     * <p> 직원의 출퇴근 정보를 확인하여 enter 일 경우 해당 직원을 {@link java.util.Set}에 추가 하고,
     * <p> leave일 경우 제거한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<String> set = new TreeSet<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();

            if ("enter".equals(log)) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        Iterator<String> it = set.descendingIterator();

        while (it.hasNext()) {
            sb.append(it.next()).append("\n");
        }

        System.out.println(sb);
    }
}