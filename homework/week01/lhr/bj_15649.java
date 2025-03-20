import java.util.Scanner;

public class bj_15649 {
    
    public static boolean [] visit; // 중복 방지 배열 
    public static int arr []; // 순열 저장 배열, 현재까지 선택된 m개의 숫자 저장
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        visit = new boolean [N]; // N개의 숫자 방문 여부 저장, 3, 1 들어왔을 때 3개의 노드에 대해 방문 여부 체크
        arr = new int [M]; // M개의 숫자 저장 배열 3, 1 들어오면 한 줄에 1개씩/4, 2 들어오면 한 줄에 2개씩
        
        dfs(N, M, 0); // depth = 0부터 시작하여 M개 선택할 때까지 탐색
        
    }
    
    // 백트래킹 (DFS, 깊이 우선 탐색)
    public static void dfs(int N, int M, int depth){ 
            
    		// 순열 개수 충족 시 출력
            if (depth == M){
                for (int val : arr){
                    System.out.print(val + " ");
                }
                System.out.println();
                return;
            }
            
            for (int i=0; i<N; i++){
                if (visit[i]==false){ // 노드를 방문 안 했으면
                    visit[i] = true; // 방문하고 true로 변경
                    arr[depth] = i+1; // depth 인덱스에 i+1 저장
                    dfs(N, M, depth+1); // 자식 노드 방문 -> 방문하지 않은 경우에 대해서만 재귀 호출
                    visit[i] = false; // 자식 노드 방문 후 다시 방문하지 않은 상태로 변경
                }
            }
        }
}
	

