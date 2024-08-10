package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon_1260 {

    static Node[] nodes;
    static int M, N, V;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 정점의 번호

        // 노드 생성
        nodes = new Node[N+1];
        for (int i = 1; i < N+1; i++) {
            nodes[i] = new Node(i);
        }

        // 연결되는 간선 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            putEdge(i1,i2);
        }

        Node r = nodes[V];
        dfs(r);

    }

    static void dfs(Node r) {
        if (r == null) return;
        r.marked = true;
        System.out.print(r.index + " -> ");
        for (Node n : r.adjacent) {

            if (!n.marked) {
                dfs(n);
            }

        }

    }


    static void putEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }


}

class Node {

    int index;
    boolean marked;
    List<Node> adjacent;

    public Node(int index) {
        this.index = index;
        this.marked = false;
        this.adjacent = new ArrayList<>();
    }
}

