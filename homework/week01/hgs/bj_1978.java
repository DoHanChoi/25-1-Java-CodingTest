package week01.homework;

import java.util.Scanner;

public class bj_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0; // 소수 개수 cnt

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num < 2) continue; // 1 이하는 스킵

            boolean isPrime = true;
            for (int j = 2; j * j <= num; j++) { // 루트num까지만 검사
                if (num % j == 0) {
                    isPrime = false;
                    break; // 소수가 아니면 더이상 검사 ㄴㄴ
                }
            }

            if (isPrime) cnt++;
        }

        System.out.println(cnt);
        sc.close();
    }
}
