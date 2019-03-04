package 剑指offer;

public class 重建二叉树 {
    private int index=0;
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) return null;
        return construct(pre,in,0,in.length);
    }

    private TreeNode construct(int[] pre, int[] in, int from, int to){
        if (from==to) return null;
        TreeNode root=new TreeNode(pre[index]);
        int rootIndex = findRoot(in, pre[index++]);
        root.left = construct(pre, in,from, rootIndex);
        root.right = construct(pre, in, rootIndex+1, to);
        return root;
    }

    private int findRoot(int[] in, int root) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = new 重建二叉树().reConstructBinaryTree(pre, in);
        System.out.println("当前类:重建二叉树.main() 第40行:treeNode值=" + treeNode);

    }
}