package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1978 {
    // 소수 판별 boolean
    private static boolean[] prime = new boolean[1001];

    // 소수 판별 함수
    private static void get_prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;

            for (int j = i*i; j < prime.length; j += i)
                prime[j] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        get_prime();

        int N = Integer.parseInt(br.readLine()); // N 입력
        st = new StringTokenizer(br.readLine()); // N개의 정수 입력
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            // 입력된 N 개의 정수 반복문을 통해 하나씩 가져옴
            int num = Integer.parseInt(st.nextToken());
            if (!prime[num])
                cnt++;
        }

        System.out.println(cnt);
    }
}
