package timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 주어진 알고리즘의 수행 횟수와, 최고차항의 차수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24262"/>Baekjoon_24262 알고리즘의 수행 시간 1</a>
 */
public class Level1 {
    /**
     * <p> 주어진 알고리즘의 수행은 무조건 1회 수행한다. 따라서 O(1)이라고 할 수 있다.
     * <p> O(1)은 단항식이므로 최고차항은 0으로 볼 수 있다.
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        br.close();
//
//        System.out.println(1 + "\n" + 0);
//    }
    static int N, M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        N = read();
        M = read();
        num = new int[N+1];

        // 누적합 계산
        for(int i=1; i<=N; i++){
            num[i] = read() + num[i-1];
        }

        for(int i=0; i<M; i++){
            int s = read();
            int e = read();
            sb.append(num[e] - num[s-1]).append('\n');
        }

        System.out.println(sb.toString());
    }


    private static int read() throws Exception{
        int c, n = System.in.read() & 15;

        while( (c = System.in.read()) > 32){
            n = (n<<3) + (n<<1) + (c&15);
        }

        if( c == 13){
            System.in.read();
        }

        return n;
    }
}
