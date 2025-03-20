package baekjoon;

import java.util.Scanner;

public class n15649 {
    // 클래스 변수 선언 (재귀 함수에서 공통으로 접근)
    static int N, M;  // N: 최대 숫자, M: 수열 길이
    static int[] arr; // 현재까지 선택된 수열 저장
    static boolean[] visited; // 숫자 사용 여부 체크
    static StringBuilder sb = new StringBuilder(); // 결과 누적 출력용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M]; // M개 수열 저장 배열 초기화
        visited = new boolean[N + 1]; // 숫자 1~N 사용 여부 체크
                                     // 숫자와 인덱스 일치시키기 위해 N+1 크기로 생성

        dfs(0); // 깊이 0부터 백트래킹 시작
        System.out.println(sb); // 모든 결과 출력

    }
    // 백트래킹 함수
    // depth: 현재 선택된 숫자개수
    public static void dfs(int depth) {
        // 종료 조건: M개의 숫자를 모두 선택한 경우
        if (depth == M) {
            // 현재 수열을 문자열로 변환
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        // 1부터 N까지 모든 숫자 시도
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 아직 사용하지 않은 숫자인 경우
                visited[i] = true; // 사용 표시
                arr[depth] = i;    // 현재 깊이 위치에 숫자 저장
                dfs(depth + 1); // 다음 단계 탐색
                visited[i] = false; // 백트래킹 사용 표시 해제
            }
        }
    }
}
