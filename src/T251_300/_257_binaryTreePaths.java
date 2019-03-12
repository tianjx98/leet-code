package T251_300;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

class _257_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dfs(result, root, sb);
        return result;
    }

    private void dfs(LinkedList<String> result, TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (sb.length() > 0) sb.append("->");
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        }
        dfs(result, root.left, sb);
        dfs(result, root.right, sb);
        int i = sb.lastIndexOf("->");
        if (i > 0) sb.delete(i, sb.length());
    }

    public static void main(String[] args) {
        Integer[] integers = {37, -34, -48, null, -100, -100, 48, null, null, null, null, -54, null, -71, -22, null, null, null, 8};
        List<String> list = new _257_binaryTreePaths().binaryTreePaths(new TreeNode(integers));
        for (String s : list) {
            System.out.println(s);
        }
    }
}