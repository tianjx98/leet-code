package 剑指offer;

import java.util.Stack;

public class 包含min函数的栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minHistory = new Stack<>();

    {
        minHistory.push(Integer.MAX_VALUE);
    }

    public void push(int node) {
        if (node < minHistory.lastElement()) {
            minHistory.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        Integer integer = stack.pop();
        if (integer.equals(minHistory.lastElement())) {
            minHistory.pop();
        }
    }

    public int top() {
        return stack.lastElement();
    }

    public int min() {
        return minHistory.lastElement();
    }
}