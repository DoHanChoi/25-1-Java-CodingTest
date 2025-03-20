package hw;

import java.util.Scanner;

public class num15649 {
    // 재귀함수 돌 때 초기화되지 않아야 하는 변수들
    static int N, M;
    static boolean[] visited;
    static int[] result;

    // DFS 알고리즘 + 백트래킹
    private static void dfs(int depth) {
        // 수열의 길이가 M이 되면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 사용 표시
                result[depth] = i; // 수열 저장
                dfs(depth + 1); // 다음 깊이로 탐색
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        result = new int[M];

        dfs(0);
    }
}
