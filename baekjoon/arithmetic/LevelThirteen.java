package baekjoon.arithmetic;

/**
 * <p> 강아지를 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/10172" />Baekjoon_10172 댕댕이</a>
 */
public class LevelThirteen {
    /**
     * <p> escape 문자 출력시 백슬래시(\)를 사용하여 표현
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("|\\_/|").append("\n");
        sb.append("|q p|   /}").append("\n");
        sb.append("( 0 )\"\"\"\\").append("\n");
        sb.append("|\"^\"`    |").append("\n");
        sb.append("||_/=\\\\__|").append("\n");

        System.out.println(sb);
    }
}
