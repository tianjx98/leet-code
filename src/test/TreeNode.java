package test;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer x) {
        val = x;
    }

    TreeNode(Integer[] tree) {
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

}