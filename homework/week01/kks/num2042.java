package hw;

import java.io.*;
import java.util.StringTokenizer;

public class num2042 {

    static long[] arr;  // 원본 배열 저장
    static long[] segTree;  // 세그먼트 트리 저장 배열


    // 세그먼트 트리 초기화 함수
    static long init(int node, int start, int end) {
        if (start == end) { // 리프 노드일 경우 (배열의 값을 그대로 저장)
            return segTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        // 왼쪽 자식과 오른쪽 자식을 재귀적으로 초기화 후 부모에 저장
        return segTree[node] = init(node*2, start, mid) + init(node*2 + 1, mid + 1, end);
    }

    // 구간 합 계산 함수
    static long sum(int node, int start, int end, int left, int right) {
        // 현재 노드의 구간이 [start, end]인데, 합을 구하는 구간 [left, right]와 전혀 겹치지 않는 경우
        if (left > end || right < start) {
            return 0;
        }

        // 현재 노드의 구간이 합을 구하는 구간에 완전히 포함될 경우
        if (left <= start && end <= right) {
            return segTree[node];
        }

        // 현재 노드의 구간이 합을 구하는 구간과 일부만 겹치는 경우 -> 자식 노드로 이동
        int mid = (start + end) / 2;

        // 왼쪽 자식과 오른쪽 자식에서 구간 합을 구해서 더함
        return sum(node*2, start, mid, left, right) + sum(node*2 + 1, mid + 1, end, left, right);
    }

    // 값 업데이트 함수
    static void update(int node, int start, int end, int idx, long diff) {
        // 변경하려는 인덱스가 현재 노드의 범위에 포함되지 않는 경우
        if (idx < start || idx > end)
            return;

        // 현재 노드에 값 갱신
        segTree[node] += diff;

        // 리프 노드가 아니라면 자식 노드로 이동해 갱신해야 함
        if (start != end) {
            int mid = (start + end) / 2;
            update(node*2, start, mid, idx, diff);
            update(node*2 +1, mid+1, end, idx,diff);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        segTree = new long[N*4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, N, b, diff);
            }
            else if (a == 2) {
                long result = sum(1, 1, N, b, (int) c);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
