package T101_150;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> nodes = new LinkedList<>();
        dfs(result, nodes, root, sum);
        return result;
    }

    private void dfs(ArrayList<List<Integer>> result, LinkedList<Integer> nodes, TreeNode root, int sum) {
        if (root == null) return;
        nodes.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                result.add((List<Integer>) nodes.clone());
            }
        }
        dfs(result, nodes, root.left, sum - root.val);
        dfs(result, nodes, root.right, sum - root.val);
        nodes.removeLast();
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode tree = new TreeNode(arr);
        List<List<Integer>> lists = new _113_pathSum().pathSum(tree, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}