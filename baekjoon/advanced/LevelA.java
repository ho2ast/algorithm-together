package baekjoon.advanced;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * <p> 새싹을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/25083"/>Baekjoon_25083 새싹</a></p>
 */
public class LevelA {
    /**
     * <p> 새싹을 그래도 출력한다. 이스케이프 문자를 조심해서 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("         ,r'\"7\n");
        bw.write("r`-_   ,'  ,/\n");
        bw.write(" \\. \". L_r'\n");
        bw.write("   `~\\/\n");
        bw.write("      |\n");
        bw.write("      |");
        bw.flush();
        bw.close();
    }
}
