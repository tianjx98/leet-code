package 剑指offer;

import java.util.Stack;

public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        用两个栈实现队列 用两个栈实现队列 = new 用两个栈实现队列();
        用两个栈实现队列.push(1);
        用两个栈实现队列.push(2);
        System.out.println(用两个栈实现队列.pop());
        用两个栈实现队列.push(3);
        用两个栈实现队列.push(4);
        System.out.println(用两个栈实现队列.pop());
        用两个栈实现队列.push(5);
        System.out.println(用两个栈实现队列.pop());
        System.out.println(用两个栈实现队列.pop());
        System.out.println(用两个栈实现队列.pop());
    }
}