package week01.homework;

import java.util.Scanner;

public class bj_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        int gcd = getGCD(n, m); // 최대공약수
        int lcm = (n * m) / gcd; // 최소공배수

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 유클리드 호제법
    public static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
