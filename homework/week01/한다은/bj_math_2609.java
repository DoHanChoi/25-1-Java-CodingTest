// 최대공약수와 최소공배수 - 유클리드 호제법
package homework.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_math_2609 {

    static int getGCD(int num1, int num2){
        // 나머지가 0이면 나눈 수(약수)를 리턴
        if (num1 % num2 == 0) return num2;

        // 아닐 경우 나머지로 다시 GCD 구하기
        /* (a, b)든 (b, a)든 어차피 나누어떨어지지 않으면 해당 나눗셈의 나머지를 이용하여
            재귀적으로 gcd를 구하기 때문에 상관없다.
        */
        return getGCD(num2, num1%num2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //두 수 입력받기
        int a = Integer.parseInt(st.nextToken()); // 첫번째 입력
        int b = Integer.parseInt(st.nextToken()); // 두번째 입력

        int gcd = getGCD(a, b);

        //최대공약수 출력
        System.out.println(gcd);

        //최소공배수 출력
        System.out.println((a*b)/gcd);

    }
}
