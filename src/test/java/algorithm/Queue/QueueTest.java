package algorithm.Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QueueTest {

    @Test
    @DisplayName("add() 과 poll() 메서드")
    void queue_Method_addAndPoll() {

        // Queue는 인터페이스 이므로 new Queue() 불가능
        Queue<Integer> queue = new LinkedList();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        Integer poll = queue.poll();

        assertThat(poll).isEqualTo(1);

        Integer poll2 = queue.poll();

        assertThat(poll2).isEqualTo(2);

    }

    @Test
    @DisplayName("remove() 메서드")
    void queue_Method_remove() {

        Queue<Integer> queue = new LinkedList();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        for (int i = 0; i < 5; i++) {
            queue.poll();
        }

        // poll 은 null을 반환
        Integer poll = queue.poll();
        assertThat(poll).isNull();

        // remove 는 NoSuchElementException 발생
        assertThatThrownBy(() -> queue.remove()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("element() 와 peek() 메서드")
    void queue_Method_elementAndPeek() {

        Queue<Integer> queue = new LinkedList();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        for (int i = 0; i < 5; i++) {
            queue.poll();
        }

        // peek() / element() 삭제요소 없이 객체를 반환

        // peek() 비어있다면 null 반환
        assertThat(queue.peek()).isNull();

        // remove() 비어있다면 NoSuchElementException 발생
        assertThatThrownBy(() -> queue.element()).isInstanceOf(NoSuchElementException.class);
    }


    @Test
    @DisplayName("add() 와 offer() 메서드")
    void queue_Method_addAbdOffer() {

        Queue<Integer> queue = new LinkedList();

        boolean offer = queue.offer(1);

        // add 저장 성공시 true 실패시 illegalStateException 발생
        // offer 저장 성공시 true 실패시 false
        assertThat(offer).isTrue();

    }
}
