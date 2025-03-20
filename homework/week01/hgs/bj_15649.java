package week01.homework;

import java.util.Scanner;

public class bj_15649 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ✅ 입력값 확인 (디버깅용) -여긴 지피티-
        System.out.println("N과 M을 입력하세요:");
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println("입력된 N: " + n + ", M: " + m); // 입력값 확인용

        // M이 N보다 크면 오류 메시지 출력 후 종료
        if (m > n) {
            System.out.println("유효하지 않은 입력입니다. (M은 N보다 크면 안 됩니다.)");
            sc.close();
            return; // 프로그램 종료
        } //-여기까지 지피티-

        arr = new int[m];
        visited = new boolean[n + 1];

        permutation(0);
        sc.close();
    }

    public static void permutation(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " "); // 공백 구분 출력
            }
            System.out.println(); // 줄 바꿈
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 중복 순열 제거
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
