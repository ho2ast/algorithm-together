package baekjoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * <p> 전공과과 학점,등급이 주어질 때 전공점을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/25206"/>Baekjoon_25206 너의 평점은</a></p>
 */
public class LevelJ {
    /**
     * <p> 주어진 학점과 평점을 곱해야 한다. 등급과 평점은 {@link java.util.Map}에 저장 해놓는다.</p>
     * <p> 등급이 P인 경우 계산에서 제외하고, 학점 * 과목평점을 해주고 학점의 총합을 별도로 계산한다.</p>
     * <p> 그 후 평점 계산을 통해 소숫점 여섯째 자리까지 출력한다.</p>
     */
    private final static Map<String, Double> gradeMap = new HashMap<>(){{
        put("A+", 4.5);
        put("A0", 4.0);
        put("B+", 3.5);
        put("B0", 3.0);
        put("C+", 2.5);
        put("C0", 2.0);
        put("D+", 1.5);
        put("D0", 1.0);
        put("F", 0.0);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sumScore = 0;
        double sumGrade = 0;
        String object = "";

        while ((object = br.readLine()) != null) {
            st = new StringTokenizer(object);
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                sumScore += score;
                sumGrade += score * gradeMap.get(grade);
            }
        }
        br.close();

        System.out.printf("%.6f%n", sumGrade / sumScore);
    }
}
