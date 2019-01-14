package T1_50;

class _42_trap {
    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/description/
     * 每个点的储水量只和它左边最高和右边最高的两个之间较小的那个有关
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;//左边最高的和右边最高的
        int result = 0;
        while (left < right) {
            leftMax = height[left] > leftMax ? height[left] : leftMax;
            rightMax = height[right] > rightMax ? height[right] : rightMax;
            if (leftMax < rightMax) {
                result += leftMax - height[left++];
            } else {
                result += rightMax - height[right--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new _42_trap().trap(arr);
        System.out.println(trap);
    }
}