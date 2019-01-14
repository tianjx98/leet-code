package T51_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _78_subsets {
    /**
     * https://leetcode-cn.com/problems/subsets/
     *
     * 回溯算法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>((int) Math.pow(2, nums.length));
        LinkedList<Integer> item=new LinkedList<>();
        backTrack(result,item,nums,0);
        return result;
    }

    private void backTrack(List result, LinkedList<Integer> item, int[] nums, int startIndex){
        result.add(item.clone());
        for (int i = startIndex; i < nums.length; i++) {
            item.add(nums[i]);
            backTrack(result,item,nums,++startIndex);
            item.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,2};
        List<List<Integer>> subsets = new _78_subsets().subsets(arr);
        System.out.println(subsets.size());
        subsets.forEach((x)->{
            x.forEach((y)-> System.out.print(y));
            System.out.println();
        });
    }
}