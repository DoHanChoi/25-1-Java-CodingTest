import java.util.*;
import java.util.stream.IntStream;

public class bj_1978 {
	
	// 소수 판별 함수 - 에라토스테네스의 체
	static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(num); i++) { // n 범위 값이 너무 커서 시간복잡도 고려 필수 -> sqrt로 수정
				if (num % i == 0) {
					return false;
				}
			}
		}
		return true; // 소수
	}

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		for (int i=0; i<n; i++) {
			int num = sc.nextInt();
			
			if (isPrime(num)) {
				cnt ++;
			}
		}
		
		System.out.print(cnt);
	    sc.close();
	}

}