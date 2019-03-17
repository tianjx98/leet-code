package T51_100;

class _63_uniquePaths {
    private int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        return recursion(m, n);
    }

    private int recursion(int m, int n) {
        if (m == 1 || n == 1) return 1;
        if (dp[m][n] > 0) return dp[m][n];
        dp[m][n] = recursion(m - 1, n) + recursion(m, n - 1);
        return dp[m][n];
    }

    public static void main(String[] args) {
        int i = new _63_uniquePaths().uniquePaths(50, 50);
        System.out.println(i);
    }
}