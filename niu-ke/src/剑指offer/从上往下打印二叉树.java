package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下打印二叉树 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            result.add(first.val);
            if (first.left != null) queue.add(first.left);
            if (first.right != null) queue.add(first.right);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}