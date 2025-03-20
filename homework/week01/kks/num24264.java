package hw;

import java.util.Scanner;

public class num24264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // 1 ≤ n ≤ 500,000. 2500억. int형 범위 초과. long형 사용

        System.out.println(n*n);
        System.out.println(2);

        sc.close();

    }
}
