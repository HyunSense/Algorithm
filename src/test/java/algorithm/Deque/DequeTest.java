package algorithm.Deque;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.*;

public class DequeTest {

    @Test
    void deque() {

        Deque deque1 = new LinkedList();

        Deque deque2 = new ArrayDeque();

    }

    @Test
    void deque_Method_add() {


        Deque deque = new LinkedList();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        deque.addFirst(4);
        deque.addLast(5);

        // 꺼낼때는 queue와같이 아래서부터 add의 경우 용량초과시 예외발생
        System.out.println("deque = " + deque); // 4 1 2 3 5
    }

    @Test
    void deque_Method_offer() {

        Deque deque = new LinkedList();
        deque.add(1);
        deque.add(2);
        deque.add(3);


        // deque에서 offer와 offerLast는 같다.
        deque.offer(4);
        deque.offerLast(5);

        deque.offerFirst(6);

        // offer의 경우 용량제한에 걸리는 경우 false
        System.out.println("deque = " + deque); // 6 1 2 3 4 5
    }

    @Test
    void deque_Method_remove() {

        Deque deque = new LinkedList();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        // 반환 값은 제거된 원소 remove 와 removeFisrt는 같다.
        Object remove = deque.remove();
        Object removeLast = deque.removeLast();
        Object removeFirst = deque.removeFirst();

        // 덱이 비어있는 경우 예외 발생
        assertThat(remove).isEqualTo(1);
        assertThat(removeFirst).isEqualTo(2);
        assertThat(removeLast).isEqualTo(5);

        System.out.println("deque = " + deque); // 3 4
    }

    @Test
    void deque_Method_poll() {


        Deque deque = new LinkedList();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        Object poll = deque.poll();
        Object pollFirst = deque.pollFirst();
        Object pollLast = deque.pollLast();

        // 덱이 비어있는 경우 null 리턴
        assertThat(poll).isEqualTo(1);
        assertThat(pollFirst).isEqualTo(2);
        assertThat(pollLast).isEqualTo(5);

        System.out.println("deque = " + deque); // 3 4
    }

    @Test
    void deque_Method_get() {


        Deque deque = new LinkedList();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        // peek() 과같이 옅보기 기능 덱이 비어있는경우 예외 발생
        Object getFirst = deque.getFirst();
        Object getLast = deque.getLast();

        assertThat(getFirst).isEqualTo(1);
        assertThat(getLast).isEqualTo(5);

        System.out.println("deque = " + deque); // 1 2 3 4 5
    }

    @Test
    void deque_Method_peek() {


        Deque deque = new LinkedList();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        // 덱이 비어있는경우 null을 리턴
        Object peek = deque.peek();
        Object peekFirst = deque.peekFirst();
        Object peekLast = deque.peekLast();

        assertThat(peek).isEqualTo(1);
        assertThat(peekFirst).isEqualTo(1);
        assertThat(peekLast).isEqualTo(5);

        System.out.println("deque = " + deque); // 1 2 3 4 5
    }
}
