package algorithm.BFS;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSTest {

    @Test
    void DfsAndBfsTest() {

        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        g.dfs(0);
    }


    static class Graph {

        static class Node {
            int data;
            LinkedList<Node> adjacent; // 인접한 노드
            boolean marked; // 노드 방문 여부

            Node(int data) {
                this.data = data;
                this.marked = false;
                this.adjacent = new LinkedList<>();
            }
        }

        Node[] nodes;
        Graph(int size) {
            this.nodes = new Node[size]; // 노드개수만큼 배열을 만든다.
            for (int i = 0; i < size; i++) {
                this.nodes[i] = new Node(i);
            }
        }
        void addEdge(int i1, int i2) { // 두 노드의 관계를 저장
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];

            if (!n1.adjacent.contains(n2)) { // 인접한 노드가 있는지 확인
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.marked = true;
            while (!stack.empty()) {
                Node r = stack.pop();
                for (Node n : r.adjacent) {
                    if (n.marked == false) {
                        n.marked = true;
                        stack.push(n);
                    }
                }
                visit(r);
            }
        }

        void bfs(int index) {
            Node root = nodes[index];
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            root.marked = true;
            while (!queue.isEmpty()) {
                Node r = queue.poll();
                for (Node n : r.adjacent) {
                    if (n.marked == false) {
                        n.marked = true;
                        queue.offer(n);
                    }
                }
                visit(r);
            }
        }

        void dsfR(Node r) { // 재귀호출을 할때는 LinkedList가 Node의 주소를 가지고있기 때문에 재귀함수는 노드를 받는 형태가 되어야 한다.
            if (r == null) return;
            r.marked = true;
            visit(r); // 자식들을 호출하기전에 데이터를 먼저 출력
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    dsfR(n);
                }
            }
        }

        void dsfR(int index) {
            Node r = nodes[index];
            dsfR(r);
        }

        void visit(Node n) {
            System.out.print(n.data + " ");
        }
    }
}
