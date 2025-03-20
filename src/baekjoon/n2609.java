package baekjoon;

import java.util.Scanner;

public class n2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int gcdResult = gcd(num1, num2);
        int lcmResult = lcm(num1, num2);

        System.out.println(gcdResult);
        System.out.println(lcmResult);
    }
    //최대공약수 구하기(유클리드 호제법)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    //최소공배수 구하기
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
