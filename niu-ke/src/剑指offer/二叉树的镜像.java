package 剑指offer;

public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }
}