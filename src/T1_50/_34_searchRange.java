package T1_50;

import java.util.Arrays;

class _34_searchRange {
    /**
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * 先用二分查找找那个数
     * 找不到返回{-1,-1}
     * 找到了就找左边和这个相等的数的下标start
     * 然后找右边和这个数相等的下标end
     * 返回{start,end}
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index<0) return new int[]{-1,-1};
        int start=index;
        while (start!=0&&nums[start-1]==nums[start]) start--;
        int end=index;
        while (end!=nums.length-1&&nums[end]==nums[end+1]) end++;
        return new int[]{start,end};
    }

    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        int[] ints = new _34_searchRange().searchRange(arr, 6);
        System.out.println(Arrays.toString(ints));
    }
}