package homework.week01;

import java.util.Scanner;

public class bj_math_8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 정수 입력받기
        int sum = 0;

        for (int i = 1; i<=num; i++){ // 1부터 입력된 숫자(num)까지 반복문 돌면서 누적합
            sum+=i;
        }
        System.out.println(sum);
        sc.close();
    }
}
