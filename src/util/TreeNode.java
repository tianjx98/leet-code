package util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    /**
     * 生成一个树节点
     * @param x
     */
    public TreeNode(Integer x) {
        val = x;
    }

    /**
     * 根据数组生成二叉树
     * @param tree
     */
    public TreeNode(Integer[] tree) {
        if (tree == null || tree.length == 0) {
            val = 0;
            return;
        }
        val = tree[0];
        generateTree(tree, this, 0);
    }

    private void generateTree(Integer[] tree, TreeNode node, int index) {
        index = 2 * index + 1;
        if (index < tree.length && tree[index] != null) {
            node.left = new TreeNode(tree[index]);
            generateTree(tree, node.left, index);
        }
        index++;
        if (index < tree.length && tree[index] != null) {
            node.right = new TreeNode(tree[index]);
            generateTree(tree, node.right, index);
        }
    }

    public void print(){

    }
}