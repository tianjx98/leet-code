package T51_100;

import java.util.Arrays;

class _88_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) return;
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * https://leetcode-cn.com/problems/merge-sorted-array/
     *
     * 从后往前合并
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n;
        m--;n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[--i] = nums1[m--];
            } else {
                nums1[--i] = nums2[n--];
            }
        }
        while (n >= 0) nums1[--i] = nums2[n--];
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        new _88_merge().merge_2(nums1,3,nums2,3);
        System.out.println("当前类:_88_merge.main() 第31行:Arrays.toString(nums1)值=" + Arrays.toString(nums1));

    }
}