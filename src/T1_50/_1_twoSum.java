package T1_50;

import java.util.Arrays;
import java.util.HashMap;

public class _1_twoSum {
    /**
     * https://leetcode-cn.com/problems/two-sum/
     *
     * 先取一个数n,然后再在数组中找target-n的数,找到了,返回这两个数的下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == tmp) {
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 将数组中所有元素放入hashMap中(值为key,下标为value)
     * 然后从数组中取一个数n,然后看hash表中是否存在target-n
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                result[1] = map.get(tmp);
                return result;
            }
        }
        return result;
    }

    public int[] twoSum_3ms(int[] nums, int target) {
        final int il = nums.length;
        int il2 = (il >> 2) - 1;

        int pot = 2;
        while((il2 >>= 1) > 0) pot <<= 1;
        final int bitMod = pot - 1;
        final int[] bucket = new int[pot];
        final int[] linked = new int[il];

        final int firstVal = nums[0];

        for (int i = 1; i < il; i++) {
            int currNum = nums[i];
            int complement = target - currNum;

            if (complement == firstVal) {
                return new int[] { 0, i };
            }

            int complementLLIndex = bucket[complement & bitMod];
            while(complementLLIndex != 0) {
                if(nums[complementLLIndex] == complement) {
                    //Found
                    return new int[] { complementLLIndex, i };
                }
                complementLLIndex = linked[complementLLIndex];
            }
            int currNumLLIndex = currNum & bitMod;
            linked[i] = bucket[currNumLLIndex];
            bucket[currNumLLIndex] = i;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new _1_twoSum().twoSumHash(new int[]{1,2,3}, 5);
        System.out.println(Arrays.toString(ints));
    }
}