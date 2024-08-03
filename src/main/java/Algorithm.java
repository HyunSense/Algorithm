import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algorithm {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < T; i++) {
            String str = bf.readLine();

            if (str.startsWith("push")) {

                String[] split = str.split(" ");
                int X = Integer.parseInt(split[1]);

                stack.push(X);

            }

            if (str.equals("pop")) {
                if (stack.empty()) {
                    result = -1;
                    System.out.println(result);
                } else {
                    result = stack.pop();
                    System.out.println(result);
                }
            }

            if (str.equals("size")) {
                result = stack.size();
                System.out.println(result);
            }

            if (str.equals("empty")) {
                if (stack.empty()) {
                    result = 1;
                    System.out.println(result);
                } else {
                    result = 0;
                    System.out.println(result);
                }
            }

            if (str.equals("top")) {

                if (stack.empty()) {
                    result = -1;
                    System.out.println(result);
                } else {
                    result = stack.peek();
                    System.out.println(result);
                }
            }
        }

    }

//    public static int solve(String str) {
//
//        Stack<Integer> stack = new Stack<>();
//        int result = 0;
//
//        for (int i = 0; i < T; i++) {
//            if (str.startsWith("push")) {
//
//                String[] split = str.split(" ");
//                int X = Integer.parseInt(split[1]);
//
//                stack.push(X);
//
//            }
//
//            if (str.equals("pop")) {
//                if (stack.empty()) {
//                    result = -1;
//                }
//
//                stack.pop();
//
//            }
//
//            if (str.equals("size")) {
//                result = stack.size();
//            }
//
//            if (str.equals("empty")) {
//                if (stack.empty()) {
//                    result = 1;
//                } else {
//                    result = 0;
//                }
//            }
//
//            if (str.equals("top")) {
//
//                if (stack.empty()) {
//                    result = -1;
//                }
//                result = stack.peek();
//            }
//        }
//
//        return result;
//    }

}
