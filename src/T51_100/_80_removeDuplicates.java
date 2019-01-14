package T51_100;

import java.util.Arrays;

class _80_removeDuplicates {
    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!(index > 0 && nums[i] == nums[index - 1])) nums[++index] = nums[i];
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,};
        int i = new _80_removeDuplicates().removeDuplicates(arr);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(arr[j]);
        }
    }
}