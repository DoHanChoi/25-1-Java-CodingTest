package homework.week01;

import java.io.*;

public class bj_math_1929 {
    static boolean[] isPrime;

    // 소수 판별 함수(에라토스테네스의 체 적용)

    /* 모든 수 소수로 가정하여 초기화
    -> 2부터 sqrt(N)까지의 수에 대해 배수를 지우는 방식으로 소수를 판별
        (N의 제곱근이라는 건 곱해서 N이 된다는 의미 = 소수가 아님.
        작은 수부터 지우면 큰 수의 약수는 작은 수의 약수이기도 하므로 앞에서 걸러짐.)
    -> M이상 N이하의 수 중 isprime이 true인 것들 출력(main)
     */

    static void sieve(int n) {
        isPrime = new boolean[n + 1];

        // 모든 수를 소수(true)로 초기화
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 적용
        for (int i = 2; i * i <= n; i++) { // 1은 소수도 합성수도 아니니까 2부터 출발
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // M과 N 입력
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        // N까지의 소수를 구함
        sieve(N);

        // M 이상 N 이하의 소수를 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        // 한 번에 출력하여 속도 향상
        System.out.print(sb);
    }
}
