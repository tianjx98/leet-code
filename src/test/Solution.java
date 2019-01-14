package test;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.val <= root.left.val) return false;
        if (root.right != null && root.val > root.right.val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isValidBst(TreeNode node, int limit){
        if (node==null) return  true;
        if (node.left != null && node.val <= node.left.val) return false;
        if (node.right != null && node.val > node.right.val) return false;

        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = new TreeNode(new Integer[]{10,5,15,null,null,6,20});
        boolean maxDepth = solution.isValidBST(tree);
        System.out.println("当前类:Solution.main():maxDepth值=" + maxDepth);

    }
}