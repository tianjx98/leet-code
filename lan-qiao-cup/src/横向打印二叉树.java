import java.util.Scanner;

public class 横向打印二叉树 {
    static class TreeNode {
        int val;
        int len;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.len = Integer.valueOf(val).toString().length() + 3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        TreeNode tree = constructTree(nums);
        printTree(tree, -1);
    }

    private static void printTree(TreeNode tree, int len) {
        if (tree == null) return;
        printTree(tree.right, tree.len + len);

        //打印节点
        System.out.print(generateDot(len));//生成点
        if (len > 0) System.out.print("-");
        System.out.print(tree.val);
        if (tree.left != null || tree.right != null) System.out.print("-|");
        System.out.println();

        printTree(tree.left, tree.len + len);
    }

    private static int count = 0;

    private static String generateDot(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == len - 1) sb.append("|");
            else sb.append(".");
        }
        return sb.toString();
    }

    private static TreeNode constructTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            addNode(root, nums[i]);
        }
        return root;
    }

    private static void addNode(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) root.left = new TreeNode(val);
            else addNode(root.left, val);
        } else {
            if (root.right == null) root.right = new TreeNode(val);
            else addNode(root.right, val);
        }
    }

}
