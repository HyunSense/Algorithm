package algorithm.Stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StackTest {


    @Test
    @DisplayName("pop() 메서드")
    void stack_Method_pop() {

        Stack stack = new Stack();


        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("stack = " + stack);

        int pop = (int) stack.pop();

        System.out.println("pop = " + pop);
        assertThat(pop).isEqualTo(5);
    }

    @Test
    @DisplayName("empty() 메서드")
    void stack_Method_empty() {

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (int i = 0; i < 5; i++) {
            stack.pop();
        }

        // 비어있다면 true, 비어있지 않다면 false
        boolean isEmpty = stack.empty();

        assertThat(isEmpty).isTrue();
    }

    @Test
    @DisplayName("peek() 메서드")
    void stack_Method_peek() {

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        int peek = (int) stack.peek();

        assertThat(peek).isEqualTo(4);

        for (int i = 0; i < 4; i++) {
            stack.peek();
        }

        assertThat(stack.isEmpty()).isFalse();

    }

    @Test
    @DisplayName("push() 메서드")
    void stack_Method_push() {

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        stack.push(5);
        stack.push(6);

        int pop = (int) stack.pop();

        assertThat(pop).isEqualTo(6);

    }

    @Test
    @DisplayName("search() 메서드")
    void stack_Method_search() {

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.push(5);
        stack.push(6);

        int search = stack.search(3);
        int search2 = stack.search(1);

        // 마지막에 push 한 곳 부터  search 시작 (index 1부터 시작)
        assertThat(search).isEqualTo(4);
        assertThat(search2).isEqualTo(6);
    }

}
