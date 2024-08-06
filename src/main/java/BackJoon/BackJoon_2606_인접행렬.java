package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2606_인접행렬 {

    static int count = 0;
    static int[][] graph;
    static boolean[] marked;

    static void dfs(int index) {

        // 방문을 하였다면 호출 종료
        if (marked[index] == true) return;

        marked[index] = true;
        count++;

        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] == 1 && !marked[i]) { // 연결된 정점이면서 방문하지 않았다면
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수(노드)
        int E = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수(간선 수)

        graph = new int[N + 1][N + 1];
        marked = new boolean[N + 1];


        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            graph[i1][i2] = graph[i2][i1] = 1;

        }

        dfs(1);
        System.out.println("count = " + count);
    }

}

