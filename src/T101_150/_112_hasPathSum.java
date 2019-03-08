package T101_150;

import util.TreeNode;

class _112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }

    private boolean hasPathSum(TreeNode root, int curSum, int sum) {
        if (root == null) return false;
        curSum += root.val;
        if (curSum == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, curSum, sum) || hasPathSum(root.right, curSum, sum);
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        //Integer[] arr={1,2,3,null,2};
        TreeNode tree = new TreeNode(arr);
        boolean b = new _112_hasPathSum().hasPathSum(tree, 22);
        System.out.println(b);
    }
}