package hw;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num4948 {
    // 최대 범위 설정(1<=n<=123456, 2n)
    private static final int max = 246912;
    // 소수 판별 boolean배열
    private static boolean[] prime = new boolean[max +1];
    // 소수 판별 함수
    private static void get_prime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;

            for (int j = i*i; j <= max; j+=i) {
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        get_prime();
        StringBuilder sb = new StringBuilder();

        // 0이 입력될 때까지 소수 판별
        while (true) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            // 0 입력 시 프로그램 종료
            if (N == 0)
                break;

            for (int i = N+1; i <= 2*N; i++) {
                if (!prime[i])
                    cnt++;
            }
            // StringBuilder에 소수 개수 넣기
            sb.append(cnt).append('\n');
        }
        // StringBuilder 출력
        System.out.println(sb);
    }
}
