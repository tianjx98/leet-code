package T1_50;

import java.util.Arrays;

class _41_firstMissingPositive {
    /**
     * https://leetcode-cn.com/problems/first-missing-positive/
     * 先将数组排序
     * 然后用二分查找元素1
     * 如果没找到就之间返回1
     * 如果找到的1后面没有元素直接返回2(可以提高速度)
     * 然后依次将后面的元素(重复就跳过)和计数器比较,如果不同找到了
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int firstIndex = Arrays.binarySearch(nums, 1);
        if (firstIndex < 0) return 1;
        if (firstIndex+1>=nums.length) return 2;
        int x = 1;
        for (int i = firstIndex+1; i < nums.length; i++) {
            while (i<nums.length-1&&nums[i - 1] == nums[i]) i++; //跳过重复元素
            if (nums[i] != ++x) {
                return x;
            }
        }
        return x+1;
    }

    public static void main(String[] args) {
//        [1,2,2,1,3,1,0,4,0]
        int[] arr = {2,0};
        int firstMissingPositive = new _41_firstMissingPositive().firstMissingPositive(arr);
        System.out.println(firstMissingPositive);
    }
}