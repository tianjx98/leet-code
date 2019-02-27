package T51_100;

import java.util.Arrays;

class _81_search {
    /**
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int reversePoint = 0;//翻转点的下标
        int i = 1, j = nums.length - 1;
        for (; i <= j; i++, j--) {
            if (nums[i - 1] > nums[i]) {
                reversePoint = i;
                break;
            }
            if (nums[j - 1] > nums[j]) {
                reversePoint = j;
                break;
            }
        }
        return Arrays.binarySearch(nums,0,reversePoint,target)>=0||
                Arrays.binarySearch(nums,reversePoint,nums.length,target)>=0;
    }

    public static void main(String[] args) {
        //int[] arr={2,2,2,0,1};
        int[] arr={2,5,6,0,0,1,2};
        boolean search = new _81_search().search(arr, 0);
        System.out.println("当前类:_81_search.main() 第27行:search值=" + search);

    }
}