package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class n4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] isPrime = new boolean[246913];
        Arrays.fill(isPrime, true); // 초기값 true 설정
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수 아님

        // 에라토스테네스의 체 생성
        for (int i = 2; i * i <= 246912; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 246912; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        while(true) {
            int n = sc.nextInt(); // 입력 받기
            if (n == 0) {   // 0 입력시 종료
                break;
            }
            int count = 0; // count 초기화
            // n+1부터 2n까지 소수 개수 카운트
            for (int i = n+1; i <= 2*n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
