// 베르트랑 공준
package homework.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bj_math_4948 {
    static boolean[] isprime; // 불리언 배열 isprime 선언

    // 소수 판별 함수(에라토스테네스의 체)
    static void isPrime(int n){
        isprime = new boolean[n+1];

        for (int i=2; i<=n; i++){
            isprime[i] = true;
        }

        // 에라토스테네스의 체 적용
        for (int i = 2; i*i<=n; i++){
            if (isprime[i]){
                for (int j = i*i; j<=n; j+=i) {
                    isprime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 자연수 n 입력
        while (true) {
            int n1 = Integer.parseInt(br.readLine());
            if (n1 == 0) break; // 0 입력 시 종료

            int n2 = n1 * 2;


            isPrime(n2);

            // n보다 크고 2n보다 작거나 같은 소수 개수 세기
            int cnt = 0;
            for (int i = n1 + 1; i <= n2; i++) {
                if (isprime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

    }
}