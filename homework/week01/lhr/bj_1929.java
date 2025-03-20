import java.util.Scanner;

public class bj_1929 {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		// 에라토스테네스의 체
		boolean[] prime = new boolean[m+1];		
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i*i < prime.length; i++) {
			if(prime[i]) continue;
			for(int j = i*i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
		
		for(int i = n; i<=m; i++) {
			if(!prime[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	    sc.close();
	}

}