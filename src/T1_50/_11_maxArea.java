package T1_50;

class _11_maxArea {
    /**
     * https://leetcode-cn.com/problems/container-with-most-water/
     *
     * 创建两个指针(i = 0, j = height.length - 1),tmp用来存储临时的面积
     * tmp = (j - i) * Math.min(height[i], height[j]),如果tmp>maxArea,就将maxArea更新
     * 将i,j中对应高高度小的那个向中间靠拢
     * 直到i,j相遇
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int tmp = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            tmp = (j - i) * Math.min(height[i], height[j]);
            if (tmp > maxArea) maxArea = tmp;
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int maxArea = new _11_maxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(maxArea);
    }
}