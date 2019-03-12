package T101_150;

import util.TreeNode;

class _124_maxPathSum {
    private int maxLen=0;
    public int maxPathSum(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {-10, 9, 20, null, null, 15, 7};
        int i = new _124_maxPathSum().maxPathSum(new TreeNode(arr));
        System.out.println(i);
    }
}