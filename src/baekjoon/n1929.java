package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class n1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1]; //소수 판별 배열 생성
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;  //0, 1은 소수가 아니라 제외

        //에라토스테네스의 체 생성
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        // M이상 N이하의 소수를 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}