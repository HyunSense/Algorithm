package BackJoon.DFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BackJoon_1260_2_인접리스트 {

    static Node2[] nodes;
    static int M, N, V;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 정점의 번호

        // 노드 생성
        nodes = new Node2[N+1];
        for (int i = 1; i < N+1; i++) {
            nodes[i] = new Node2(i);
        }

        // 연결되는 간선 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            putEdge(i1,i2);
        }

        Node2 r = nodes[V];
        sb = new StringBuilder();
        dfs(r);
        System.out.println(sb);

        for (int i = 1; i < N+1; i++) {
            nodes[i].marked = false;
        }

        sb = new StringBuilder();
        bfs(r);
        System.out.println(sb);
    }

    static void dfs(Node2 r) {
        if (r == null) return;
        r.marked = true;
//        System.out.print(r.num + " -> ");
        sb.append(r.num).append(" ");
        for (int n : r.adjacent) {
            Node2 node = nodes[n];
            if (!node.marked) {
                dfs(node);
            }
        }

    }

    static void bfs(Node2 r) {
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(r);
        r.marked = true;

        while (!queue.isEmpty()) {

            Node2 poll = queue.poll();
            List<Integer> adjacent = poll.adjacent;
            for (int n : adjacent) {
                Node2 node = nodes[n];
                if (!node.marked) {
                    node.marked = true;
                    queue.offer(node);
                }
            }

            sb.append(poll.num).append(" ");
        }
    }


    static void putEdge(int i1, int i2) {
        Node2 n1 = nodes[i1];
        Node2 n2 = nodes[i2];

        if (!n1.adjacent.contains(n2.num)) {
            n1.adjacent.add(n2.num);
        }

        if (!n2.adjacent.contains(n1.num)) {
            n2.adjacent.add(n1.num);
        }

        Collections.sort(n1.adjacent);
        Collections.sort(n2.adjacent);
    }


}

class Node2 {

    int num;
    boolean marked;
    List<Integer> adjacent;

    public Node2(int num) {
        this.num = num;
        this.marked = false;
        this.adjacent = new ArrayList<>();
    }
}

