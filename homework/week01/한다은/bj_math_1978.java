// 소수 찾기
package homework.week01;

import java.io.*;
import java.util.StringTokenizer;

public class bj_math_1978 {
    static boolean[] isPrime;

    // 소수 판별 함수 (에라토스테네스의 체)
    static void sieve(int n) {
        isPrime = new boolean[n + 1];

        // 모든 숫자를 소수(true)로 초기화
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        // 0과 1은 소수가 아님
        isPrime[0] = isPrime[1] = false;

        // 에라토스테네스의 체 알고리즘 적용
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        // 숫자 입력 (공백 기준으로 분리)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNumber = 0;

        // 입력된 수들을 배열에 저장하면서 최대값 찾기 (소수 판별 범위 설정)
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            maxNumber = Math.max(maxNumber, numbers[i]);
        }

        // 에라토스테네스의 체 실행 (최대값까지)
        sieve(maxNumber);

        // 소수 개수 세기
        int primeCount = 0;
        for (int num : numbers) {
            if (isPrime[num]) {
                primeCount++;
            }
        }

        // 결과 출력
        System.out.println(primeCount);
    }
}
