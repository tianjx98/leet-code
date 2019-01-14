package T1_50;

public class _27_removeElement {
    /**
     * https://leetcode-cn.com/problems/remove-element/
     * 将后面不等于val的值填到前面等于val的值上面
     *
     * 前(left)后(right)两个指针,count用来记录删除的元素个数
     * 先从前往后找等于val的元素,找到之后count++
     * 然后从后往前找不等于val的元素,等于val就count++,直到不等于val就停下来
     * 将后面指针指向的值赋值给前面指针的值,left++,right--
     * 重复上面步骤直到两个指针相遇
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;//记要删除的数的个数
        while (left <= right) {
            while (left <= right) {//从头开始找等于val的数
                if (nums[left] == val) {
                    count++;
                    break;
                }
                left++;
            }
            while (left < right) {
                if (nums[right] != val) {
                    break;
                }
                count++;
                right--;
            }
            if (left < right) {
                nums[left] = nums[right--];
            } else {
                break;
            }
        }
        return nums.length - count;
    }

    public int removeElement_5ms(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
//        int[] arr = {3};
        int len = new _27_removeElement().removeElement_5ms(arr, 2);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}