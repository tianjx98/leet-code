package T51_100;

import java.util.Arrays;
import java.util.LinkedList;

class _60_getPermutation {
    /**
     * https://leetcode-cn.com/problems/permutation-sequence/
     *
     * 递归
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<>();
        //先生成数的集合
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuffer result = new StringBuffer(n);//存储结果
        find(result, nums, 0, k);//开始递归
        return result.toString();
    }

    private void find(StringBuffer result, LinkedList<Integer> nums, int index, int k) {
        if (nums.size() == 1) {//如果只剩最后一个元素就将其加到结果最后一个
            result.append(nums.removeLast());
            return;
        }
        //n开头的数有多少个(n后面有多少个数的排列组合就有多少个)
        int fac = factorial(nums.size() - 1);
        int hIndex = (k - 1) / fac;//判断n的位置
        result.append(nums.remove(hIndex));//将加到结果中
        find(result, nums, index + 1, k - hIndex * fac);//递归
    }

    /**
     * 计算n的阶乘
     * @param n
     * @return
     */
    private int factorial(int n) {
        int m = 1;
        for (int i = 2; i <= n; i++) {
            m *= i;
        }
        return m;
    }

    public static void main(String[] args) {
        String permutation = new _60_getPermutation().getPermutation(3, 6);
        System.out.println(permutation);
    }
}