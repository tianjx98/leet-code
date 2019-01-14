package T1_50;

class _35_searchInsert {
    /**
     * https://leetcode-cn.com/problems/search-insert-position/
     * 使用二分查找找到比<=target >=target的数,然后返回下标
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            if (mid - 1 < 0 || nums[mid - 1] < target) return mid;
            return search(nums, start, mid, target);
        } else if (nums[mid] < target) {
            if (mid + 1 >= nums.length || nums[mid + 1] > target) return mid + 1;
            return search(nums, mid, end, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int search = new _35_searchInsert().searchInsert(arr, 4);
        System.out.println(search);
    }
}