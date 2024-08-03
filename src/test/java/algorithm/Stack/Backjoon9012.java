package algorithm.Stack;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Stack;

public class Backjoon9012 {

    @Test
    void test() {

        String str = function("(((()())()");
        System.out.println("str = " + str);
    }

    public static String function(String str) {



        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);


            if (c == '(') {
                stack.push(c);

            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
