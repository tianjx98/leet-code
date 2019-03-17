package T51_100;

class _64_minPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    ;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];//第一行
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];//第一列
                } else {
                    grid[i][j] += grid[i - 1][j] > grid[i][j - 1] ? grid[i][j - 1] : grid[i - 1][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] ints = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int i = new _64_minPathSum().minPathSum(ints);
        System.out.println(i);
    }
}