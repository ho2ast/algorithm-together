package baekjoon.arithmetic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * "Hello World!"를 출력하세요.
 */
public class LevelOne {
    /**
     * <p>출력의 속도는 System.out.println() 보다
     * <p>{@link BufferedWriter} 의 write()를 쓰는것이 약 30배 빠르다고 함.
     * <p>StringBuilder를 이용해 문자열 하나로 만든 다음
     * <p> System.out.println(); 하는 것도 나쁘지 않다
     * @see <a href="https://www.acmicpc.net/blog/view/57">출력 속도 비교</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("Hello World!");
        bw.close();
    }
}