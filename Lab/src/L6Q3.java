

import java.util.Stack;

public class L6Q3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 10; i += 2)
            stack.push(i);
        System.out.println("Sum: " + sum(stack));
    }

    public static int sum(Stack<Integer> S) {
        int sum = 0;
        while (!S.isEmpty())
            sum += S.pop();
        return sum;
    }
}

