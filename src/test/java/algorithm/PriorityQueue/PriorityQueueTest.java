package algorithm.PriorityQueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    @Test
    void priorityQueue() {

        PriorityQueue pq = new PriorityQueue();

        pq.offer(2);
        pq.offer(3);
        pq.offer(1);
        pq.offer(6);
        pq.offer(5);
        pq.offer(4);

        // 저장순서와 다르게 출력
        System.out.println("pq = " + pq); // 1 3 2 6 5 4


        // PriorityQueue poll() 로 꺼냄
        for (int i = 0; i < 6; i++) {

            // 숫자가 작은 것이 우선순위를 가져서 꺼내온다
            Object poll = pq.poll();
            System.out.println(poll);

        }
    }
}
