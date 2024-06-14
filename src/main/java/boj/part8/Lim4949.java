package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Lim4949 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder result = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals(".")) {
            final Stack<Character> stack = new Stack<>();

            boolean isBalanced = true;
            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isBalanced = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isBalanced = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (isBalanced && stack.isEmpty()) {
                result.append("yes\n");
            } else {
                result.append("no\n");
            }
        }

        System.out.println(result);
    }
}
