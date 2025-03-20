// N과 M(1)
package homework.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_math_15649 {
    static int N, M;
    static boolean[] visited; // 방문 여부 체크
    static int[] arr; //순열 저장 배열 선언
    static StringBuilder sb = new StringBuilder();

    static void backtrack(int depth){

        // 수열 한 줄 만들기
        if (depth == M){ // M개 골라서 수열 생성 -> M번 반복해야함
            for (int i = 0; i<M; i++){
                sb.append(arr[i]).append(" "); //공백으로 구분하여 붙이기
            }
            sb.append("\n"); // 한 줄 다 만들었으면 줄바꿈
            return;
        }

        //
        for (int i = 1; i<=N; i++){ // 1부터 N까지 모든 수 탐방
            if (!visited[i]){
                visited[i] = true; // 방문 체크
                arr[depth] = i; // 현재 위치에 숫자 저장
                backtrack(depth+1); // 다음 숫자 선택을 위해 재귀 호출
                visited[i] = false; // 백트래킹(원상복구)
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        // 입력값 선언
        M = Integer.parseInt(input[1]);
        N = Integer.parseInt(input[0]);

        visited = new boolean[N + 1]; // 방문 여부 배열
        arr = new int[M]; // 순열 저장 배열

        // 백트래킹 시작
        backtrack(0);
        System.out.println(sb);

    }
}
