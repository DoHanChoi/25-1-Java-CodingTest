package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1929 {

    private static boolean[] prime;

    // 소수: false
    private static void get_prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;

            // i*i인 이유는 그 전 수는 앞서서 판별했기 때문
            for (int j = i*i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new boolean[N+1];
        get_prime();

        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++) {
            if (!prime[i])
                sb.append(i + "\n");
        }
        System.out.println(sb);

    }
}
