package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_2606_인접리스트 {

    static int count = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine()); // 컴퓨터 수(노드)
        int L = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수(간선 수)

        // 노드의 개수만큼 배열을 만든다.
//        int[] nodes = new int[C];
        Node[] nodes = new Node[C+1];

        for (int i = 1; i < C+1; i++) {
            nodes[i] = new Node(i);
        }


        // 노드의 관계들을 저장한다.
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            Node n1 = nodes[i1];
            Node n2 = nodes[i2];

            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }

            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }

        }

        Node node = nodes[1];
        dsfR(node);
        System.out.println(count-1);
    }

    static class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.marked = false;
        }
    }
    static void dsfR(Node r) {
        r.marked = true;
        count++;
        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dsfR(n);
            }
        }
    }
}

