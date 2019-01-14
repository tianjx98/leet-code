package T51_100;

import java.util.Arrays;

class _75_sortColors {
    /**
     * https://leetcode-cn.com/problems/sort-colors/
     * <p>
     * 将0交换到前面,2交换到后面
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int i = -1, j = nums.length, k = 0;
        while (k < j) {
            if (nums[k] == 0) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                k++;
            } else if (nums[k] == 2) {
                j--;
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
            } else k++;
        }
    }

    /**
     * 计数排序
     * @param nums
     */
    public void sortColors_countSort(int[] nums) {
        int zero = 0, one = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            }
        }
        Arrays.fill(nums, 0, zero, 0);
        Arrays.fill(nums, zero, zero + one, 1);
        Arrays.fill(nums, zero + one, nums.length, 2);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 0, 2, 1, 2};
        new _75_sortColors().sortColors_countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}