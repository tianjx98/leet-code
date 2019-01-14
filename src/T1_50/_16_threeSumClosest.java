package T1_50;

import java.util.Arrays;

public class _16_threeSumClosest {
    /**
     * https://leetcode-cn.com/problems/3sum-closest/
     * 用三数之和的方法找出所有三个数的组合,然后将和target最接近的保留下来
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = 999999;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    int interval = Math.abs(target - sum);
                    closestNum = Math.abs(target-closestNum) > interval ? sum : closestNum;
                    if (sum > target) {
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    }else if(sum<target) {
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                    }else {
                        return closestNum;
                    }
                }
            }
        }
        return closestNum;
    }

    public static void main(String[] args) {
//        int[] arr={0,2,1,-3};//0
//        int[] arr={-1,2,1,-4};
//        int[] arr={1,1,-1,-1,3};//-1
//        int[] arr={-1,0,1,1,55};//2
        int[] arr={13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
        int closest = new _16_threeSumClosest().threeSumClosest(arr, -59);
        System.out.println(closest);
    }
} 