package T1_50;

import java.util.Arrays;

class _33_search {
    /**
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
     * 先判断数组为null或长度为0就直接返回-1
     * 头尾两个指针找出翻转的位置
     * 然后对两段数组分别使用二分查找(只有一段又target)
     * 返回>0的结果
     * 如果两个都小于0,返回-1
     *
     * 注意: Arrays.binarySearch 找不到元素会返回一个负数(不一定是-1),如果数组中又重复元素,返回的下标为这些重复元素中的一个(不确定)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int reversePoint = 0;//翻转点的下标
        int i = 1, j = nums.length - 1;
        for (; i <= j; i++, j--) {
            if (nums[i - 1] >= nums[i]) {
                reversePoint = i;
                break;
            }
            if (nums[j - 1] >= nums[j]) {
                reversePoint = j;
                break;
            }
        }
        int index1 = Arrays.binarySearch(nums, 0, reversePoint, target);
        int index2 = Arrays.binarySearch(nums, reversePoint, nums.length, target);
        if(index1<0&&index2<0) return -1;
        return index1 > index2 ? index1 : index2;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
//        int[] arr = {2};
        int index = new _33_search().search(arr, 2);
        System.out.println(index);
    }
}