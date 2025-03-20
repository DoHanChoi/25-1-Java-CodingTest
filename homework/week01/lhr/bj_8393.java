import java.util.*;

public class bj_8393 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int sum = 0;
		
		for (int i=1; i<n+1; i++) {
			sum += i;
		}
		
		System.out.print(sum);
	}

}