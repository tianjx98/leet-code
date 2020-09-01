package T1501_1550;

import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (int value : map.values()) {
            sum += (value - 1) * value / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = new Solution().numIdenticalPairs(new int[]{1,2,3,1,1,3});
        System.out.println(i);
    }
}