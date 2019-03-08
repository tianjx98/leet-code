package 剑指offer;

import java.util.Stack;

public class 栈的压入_弹出序列 {
    /**
     * 从push队列中第一个开始找
     * 如果和pop队列中第一个不相等,入栈
     * 相等,pop push队列指针都往后移一位
     * push队列元素取完后
     * 将栈中元素一次弹出与pop队列中比较, 不相等返回false
     * 最后返回true
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int pushIndex = 0, popIndex = 0;
        Stack<Integer> stack = new Stack<>();

        while (pushIndex < pushA.length) {
            if (pushA[pushIndex] != popA[popIndex]) {
                stack.push(pushA[pushIndex++]);
            } else {
                popIndex++;
                pushIndex++;
            }
        }
        while (stack.size() != 0) {
            if (stack.pop() != popA[popIndex++]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        boolean isPopOrder = new 栈的压入_弹出序列().IsPopOrder(pushA, popA);
        System.out.println(isPopOrder);
    }
}