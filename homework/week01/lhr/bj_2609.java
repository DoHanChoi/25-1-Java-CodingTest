import java.util.*;

public class bj_2609 {
	// 유클리드 호제법
	// MOD 연산 - A를 B로 나눈 나머지를 구하는 연산
	// A % B = C, B % C = D, D % E = F, ...
	public static int gcd(int n, int m) {
        int r;
        while(m > 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    
    	// 두 수에서 더 큰 수를 n으로 지정
        if(n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        
        // 최대공약수 구하기
        int min = gcd(n, m);
        
        // 최소공배수 구하기
        // 최소공배수 * 최대공약수 = 두 수의 곱
    	// 최소공배수 = (두 수의 곱)/최대공약수
        int max = n * m / min;
    	
    	System.out.println(min);
    	System.out.print(max);
    
    }

}