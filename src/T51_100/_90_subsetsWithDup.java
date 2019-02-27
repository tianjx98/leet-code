package T51_100;

import java.util.*;

class _90_subsetsWithDup {
    /**
     * https://leetcode-cn.com/problems/subsets-ii/
     *
     * 将数组排序然后使用hashSet去重
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> lists = new HashSet<>();
        List<List<Integer>> result = new ArrayList((int) Math.pow(2, nums.length));
        ArrayList<Integer> item = new ArrayList<>();
        Arrays.sort(nums);//将数组排序
        backTrack(lists, item, nums, 0);
        for (List<Integer> o:lists){
            result.add(o);
        }
        return result;
    }

    private void backTrack(HashSet result, ArrayList<Integer> item, int[] arr, int index){
        result.add(item.clone());
        for (int i = index; i < arr.length; i++) {
            item.add(arr[i]);
            backTrack(result, item, arr, ++index);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr={4,4,4,1,4};
        List<List<Integer>> lists = new _90_subsetsWithDup().subsetsWithDup(arr);
        System.out.println("当前类:_90_subsetsWithDup.main() 第33行:lists值=" + lists);

    }
}