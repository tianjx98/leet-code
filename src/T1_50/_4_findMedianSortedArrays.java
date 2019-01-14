package T1_50;

public class _4_findMedianSortedArrays {
    /**
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     *
     * 先将两个数组合并为一个(类似于归并排序中的合并)
     * 如果有偶数个数,返回中间两个数的平均值
     * 如果有奇数个数,直接返回中间那个数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0;
        int i = 0, j = 0, k = 0;
        int[] n1, n2;
        if (nums1.length <= nums2.length) { // n1总为最短
            n1 = nums1;
            n2 = nums2;
        } else {
            n1 = nums2;
            n2 = nums1;
        }
        int length1 = n1.length, length2 = n2.length;
        int len = length1 + length2;
        int[] nums = new int[len];
        while (i < length1 && j < length2) { // 分别从两个里面取出较小的数放到nums,直到一个取完
            if (n1[i] < n2[j]) {
                nums[k++] = n1[i++];
            } else {
                nums[k++] = n2[j++];
            }
        }
        while (i < length1) {
            nums[k++] = n1[i++];
        }
        while (j < length2) {
            nums[k++] = n2[j++];
        }

        if ((len % 2) == 0) {
            mid = nums[len / 2] + nums[len / 2 - 1];
            mid = mid / 2;
        } else {
            mid = nums[len / 2];
        }
        return mid;
    }

    public static void main(String[] args) {
        double mid = new _4_findMedianSortedArrays().findMedianSortedArrays(new int[]{1,3}, new int[]{-2, -1});
        System.out.println(mid);
    }
}