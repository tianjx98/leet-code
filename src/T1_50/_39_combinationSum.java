package T1_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _39_combinationSum {
    /**
     * https://leetcode-cn.com/problems/combination-sum/
     * <p>
     * 回溯算法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> item = new LinkedList<>();
        backTrack(result, item, candidates, 0, target);
        return result;
    }

    private void backTrack(List result, LinkedList<Integer> item, int[] candidates, int startIndex, int target) {
        if (target < 0) return;
        if (target == 0) {
            result.add(item.clone());
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            item.add(candidates[i]);
            backTrack(result, item, candidates, i, target - candidates[i]);// i是保证元素可以重复
            item.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 7};
        List<List<Integer>> lists = new _39_combinationSum().combinationSum(arr, 7);
        System.out.println(lists.size());
        lists.forEach((x) -> {
            x.forEach((y) -> System.out.print(y));
            System.out.println();
        });
    }
}