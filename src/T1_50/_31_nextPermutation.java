package T1_50;

import java.util.Arrays;

class _31_nextPermutation {
    /**
     * https://leetcode-cn.com/problems/next-permutation/
     * 如果是降序排列(最大值),就直接将其升序排列变成最小
     * 从倒数第二个数开始依次往前(记为n),如果n后面有比n大的数
     * 找到这些比n大的数里面最小的一个与n交换位置
     * 将数组中n(交换之前的那个位置)后面的数从小到大排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        boolean isDesc=true;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]<nums[i+1]){
                isDesc=false;
            }
        }
        if (isDesc) {//数组为降序排列就直接从小到大排序
            Arrays.sort(nums);
            return;
        }
        // 不为降序排列
        for (int i = nums.length-2; i >=0 ; i--) {
            int tmpIndex=i+1;
            boolean isFinded=false;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]>nums[i]&&nums[j]<=nums[tmpIndex]) {
                    tmpIndex=j;
                    isFinded=true;
                }
            }
            if (isFinded) {
                int tmp=nums[i];
                nums[i]=nums[tmpIndex];
                nums[tmpIndex]=tmp;
                Arrays.sort(nums,i+1,nums.length);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,6,7,5,1,1};
//        int[] arr={1,3,2};
        new _31_nextPermutation().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
//1,2,7,1,5,1,6