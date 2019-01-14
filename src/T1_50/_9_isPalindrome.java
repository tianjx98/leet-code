package T1_50;

class _9_isPalindrome {
    /**
     * https://leetcode-cn.com/problems/palindrome-number/
     *
     * 如果是负数直接返回false
     * 将数的每一位取出放到一个int数组里面,然后判断前面的数是否等于后面对应的数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int[] nums = new int[10];
        int k = -1;
        while (x != 0) {
            nums[++k] = x % 10;
            x = x / 10;
        }
        for (int i = 0; i < k; i++, k--) {
            if (nums[i] != nums[k]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = new _9_isPalindrome().isPalindrome(1521);
        System.out.println(palindrome);
    }
}