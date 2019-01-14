package T1_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _18_fourSum {
    /**
     * https://leetcode-cn.com/problems/4sum/
     *
     * 将四数之和变为三数之和(多一层循环)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int k = 0; k < nums.length - 3; k++) {
            if (k == 0 || (k > 0 && nums[k] != nums[k - 1])){
                for (int i = k + 1; i < nums.length - 2; i++) {
                    if (i == k+1 || (i > k+1 && nums[i] != nums[i - 1])) { //nums[i]要是一组重复元素中的第一个
                        int left = i + 1, right = nums.length - 1, sum = target - nums[i] - nums[k];
                        while (left < right) {
                            if (sum == nums[left] + nums[right]) {
                                result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                                // 如果有重复就跳过重复元素
                                while (left < right && nums[left] == nums[left + 1]) left++;
                                while (left < right && nums[right] == nums[right - 1]) right--;
                                left++;
                                right--;
                            } else if (nums[left] + nums[right] < sum) {// 小于就让左边指针右移,整体就会变大
                                left++;
                            } else { // 大于,右边指针左移
                                right--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] arr={1, 0, -1, 0, -2, 2};
//        int[] arr = {0, 0, 0, 0};
//        int[] arr={-1,0,1,2,-1,-4};
//        int[] arr={-1,-5,-5,-3,2,5,0,4};//-7
        int[] arr={1,0,-1,0,-2,2};//0
        List<List<Integer>> lists = new _18_fourSum().fourSum(arr, 0);
        lists.forEach((x) -> System.out.println(x.toString()));
    }
}