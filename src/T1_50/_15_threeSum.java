package T1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class _15_threeSum {
    /**
     * https://leetcode-cn.com/problems/3sum/
     *
     * 先将数组排序
     * 如果数组中又三个及以上的0,结果中包含[0,0,0]
     * 如果全为正数或者全为负数直接返回
     * 两负一正
     * 找出所有两个负数的组合,然后找出他们和的相反数,不重复就插入结果集
     * 两正一负
     * 找出所有两个正数的组合,然后找出他们和的相反数,不重复就插入结果集
     * 测试
     * 600+ms
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result1 = new ArrayList<List<Integer>>(50);
        List<List<Integer>> result2 = new ArrayList<List<Integer>>(50);
        Arrays.sort(nums);
        int midIndex = -1;//第一个大于等于0的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                midIndex = i;
                break;
            }
        }
        //有三个以上的0
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        if (count >= 3) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            result1.add(list);
        }
        if (midIndex == 0 || midIndex == -1) return result1;//如果全为正数或全为负数,直接返回

        for (int i = 0; i < midIndex - 1; i++) {//两个负数一个正数
            for (int j = i + 1; j < midIndex; j++) {
                int absNumIndex = Arrays.binarySearch(nums, midIndex, nums.length, -(nums[i] + nums[j]));
                if (absNumIndex >= 0) {
                    insertToResult(result1, nums[i], nums[j], nums[absNumIndex]);
                }
            }
        }

        for (int i = midIndex; i < nums.length - 1; i++) {//两个正数一个负数
            for (int j = i + 1; j < nums.length; j++) {
                int absNumIndex = Arrays.binarySearch(nums, 0, midIndex, -(nums[i] + nums[j]));
                if (absNumIndex >= 0) {
                    insertToResult(result2, nums[absNumIndex], nums[i], nums[j]);
                }
            }
        }
        result1.addAll(result2);
        return result1;
    }

    private void insertToResult(List<List<Integer>> result, int one, int two, int three) {
        boolean isContains = false;
        for (List<Integer> list : result) {
            if (list.get(0) == one && list.get(1) == two && list.get(2) == three) {
                isContains = true;
            }
        }
        if (!isContains) { //如果不存在才加进去
            ArrayList<Integer> list = new ArrayList<>();
            list.add(one);
            list.add(two);
            list.add(three);
            result.add(list);
        }
    }


    public List<List<Integer>> threeSum_60ms(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    /**
     * 先将数组排序
     * 遍历[0,length-2],如果有重复元素,就取重复元素的第一个
     *      left=i+1,right=length-1,sum=0-nums[i]
     *      如果nums[left]+nums[right]==sum就说明找到一组,将其加入结果集,有重复元素就跳过
     *      如果nums[left]+nums[right]<sum,就将left右移,整体变大
     *      如果nums[left]+nums[right]>sum,right左移,整体变小
     *      left和right相遇就跳出循环
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_copy(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //nums[i]要是一组重复元素中的第一个
                int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
                while (left < right) {
                    if (sum == nums[left] + nums[right]) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
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
        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {-1, 0, 1, -1, 2, -1, -1, -4, 0, 0, 0};
        int[] arr={0,0,0};
//        List<List<Integer>> list = new _15_threeSum().threeSum_60ms(arr);
        List<List<Integer>> lists = new _15_threeSum().threeSum_copy(arr);
//        list.forEach((l) -> System.out.println(l.toString()));
        System.out.println("-------------------");
        lists.forEach((l) -> System.out.println(l.toString()));
    }
}