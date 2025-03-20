package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class n1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //정수의 개수
        int count = 0;

        //에라토스테네스의 체
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true); // 초기값 true 설정
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수 아님

        // 체 생성 (2 ~ √1000 순회)
        for (int i = 2; i * i <= 1000; i++) {
            // i가 소수인 경우
            if (isPrime[i]) {
                // i의 베수 제거
                for (int j = i * i; j <= 1000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        // N개의 수 중, 소수의 개수 카운트
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt(); // 검사할 숫자 입력
            // i가 소수이면 카운트 증가
            if (isPrime[num]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
