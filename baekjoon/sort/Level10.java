package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p> 나이와 회원명이 주어질 때 나이순으로, 나이가 같을 경우 가입순으로 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10814"/>Baekjoon_10814 나이순 정렬</a>
 */
public class Level10 {
    /**
     * <p> 회원 정보는 가입순으로 주어진다.
     * <p> 나이가 같을 경우 가입순으로 정렬해야 하는데 가입순으로 주어지기 때문에 안정정렬을 이용하여 문제를 해결한다.
     * <p> 회원 객체를 생성하고 {@link Comparable}과 {@link java.util.Comparator}를 이용하여 정렬한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        User[] users = new User[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            users[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        // Comparable 사용
//        Arrays.sort(users);


        // Comparator 사용
        Arrays.sort(users, ((o1, o2) -> o1.age - o2.age));

        for (User user : users) {
            sb.append(user.age).append(" ").append(user.name).append("\n");
        }

        System.out.println(sb);
    }

    static class User implements Comparable<User> {
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User user) {
            return this.age - user.age;
        }
    }
}
