package hw;

import java.util.Scanner;

public class num2609 {
    // 최대공약수 -> 유클리드호제법으로 구함
    private static int gcd(int n, int m) {
        if (m == 0)
            return n;

        // m==0일 때 까지 재귀
        return gcd(m, n%m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int gcd = gcd(N, M);

        System.out.println(gcd);
        System.out.println(N*M/gcd); // 최소공배수 = 두 수의 곱 / 최대공약수
    }
}
