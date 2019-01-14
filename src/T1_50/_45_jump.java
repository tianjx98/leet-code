package T1_50;

class _45_jump {
    /**
     * https://leetcode-cn.com/problems/jump-game-ii/
     *
     * 从i=0开始,在i所能到达的范围(i+1,i+nums[i])内找出最最大权值的下标(index+nums[index]),然后跳到这个下标
     * 每次循环将result++,直到能够到最后
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length==0||nums.length==1) return 0;
        int result=0;
        for (int i = 0; i < nums.length; ) {
            result++;
            if (i+nums[i]>=nums.length-1) return result;
            int range=i+nums[i];
            int optimumIndex=i+1;
            for (int j = i+2; j <= range; j++) {// i所能跳的范围,在这个里面找出最优的下标,以index+nums[index]为权值,越大说明越靠后
                if (optimumIndex+nums[optimumIndex]<j+nums[j]) optimumIndex=j;
            }
            i=optimumIndex;
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] arr={2,3,1,1,4};
        int[] arr={1,2};
        int jump = new _45_jump().jump(arr);
        System.out.println(jump);
    }
}