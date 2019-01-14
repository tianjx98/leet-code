package T1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class _39_combinationSum2 {
    /**
     * https://leetcode-cn.com/problems/combination-sum-ii/
     *
     * 回溯算法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> item = new LinkedList<>();
        backTrack2(result, item, candidates, 0, target);
        return result;
    }

    private void backTrack2(List result, LinkedList<Integer> item, int[] candidates, int startIndex, int target) {
        if (target < 0) return;
        if (target == 0) {
            result.add(item.clone());
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i==startIndex||candidates[i-1]!=candidates[i]) { //从start开始,重复元素只使用第一个,后面的跳过,避免产生重复结果
                item.add(candidates[i]);
                backTrack2(result, item, candidates, i + 1, target - candidates[i]);//i+1, 元素不能重复
                item.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = new _39_combinationSum2().combinationSum2(arr, 8);
        System.out.println(lists.size());
        lists.forEach((x) -> {
            x.forEach((y) -> System.out.print(y));
            System.out.println();
        });
    }
}