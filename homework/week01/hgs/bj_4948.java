package week01.homework;

import java.util.Scanner;

public class bj_4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break; // 0 입력으로 종료
            boolean[] prime = new boolean[2*n + 1];

            // 에라토스테네스
            prime[0] = prime[1] = true;
            for (int i = 2; i * i <= 2*n; i++) {
                if (!prime[i]) {
                    for (int j = i*i; j <= 2 * n; j += i) {
                        prime[j] = true;
                    }
                }
            }

            // n up, 2n down 소수
            int cnt = 0;
            for (int i = n+1; i <= 2 * n; i++) {
                if (!prime[i]) cnt++;
            }

            System.out.println(cnt);
        }

        sc.close();
    }
}
