package arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 정수 A와 B를 입력받은 다음, A-B를 출력하세요.
 */
public class LevelThree {
    /**
     * <p>입력의 속도 Scanner 보다 {@link BufferedReader} 를 쓰는것이 약 8배 빠르다고 함.
     * <p>또한, 입력값을 split()을 이용하기 자르기 보다 {@link StringTokenizer}를 사용하는 것이 빠름
     *
     * @see <a href="https://www.acmicpc.net/blog/view/56" />입력 속도 비교</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 여기서는 단순한 한줄 출력이므로 System.out.println() 사용
        System.out.println(a - b);
    }
}
