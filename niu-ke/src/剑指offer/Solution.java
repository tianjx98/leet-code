package 剑指offer;

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String iString = Integer.toString(i);
            for (int j = 0; j < iString.length(); j++) {
                if (iString.charAt(j) == '1') count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new Solution().NumberOf1Between1AndN_Solution(13);
        System.out.println(i);
    }
}