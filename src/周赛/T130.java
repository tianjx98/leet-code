package 周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T130 {
    private int height = 0;
    private int width = 0;

    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        height = A.length;
        width = A[0].length;
        //flag为true就能走出去
        boolean[][] flag = new boolean[A.length][A[0].length];
        for (int i = 0; i < width; i++) if (A[0][i] == 1) flag[0][i] = true;
        for (int i = 0; i < width; i++) if (A[height - 1][i] == 1) flag[height - 1][i] = true;
        for (int i = 1; i < height - 1; i++) if (A[i][0] == 1) flag[i][0] = true;
        for (int i = 1; i < height - 1; i++) if (A[i][width - 1] == 1) flag[i][width - 1] = true;

        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (A[i][j] == 1) dfs(flag, A, i, j);
            }
        }
        int res = 0;
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (A[i][j] == 1 && !flag[i][j]) res++;
            }
        }
        return res;
    }

    private void dfs(boolean[][] flag, int[][] a, int x, int y) {
        if (flag[x - 1][y] || flag[x + 1][y] || flag[x][y - 1] || flag[x][y + 1]) {
            flag[x][y] = true;
            if (a[x - 1][y] == 1) flag[x - 1][y] = true;
            if (a[x + 1][y] == 1) flag[x + 1][y] = true;
            if (a[x][y - 1] == 1) flag[x][y - 1] = true;
            if (a[x][y + 1] == 1) flag[x][y + 1] = true;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 0, 1, 1, 1}, {
                0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {0, 1, 1, 0, 0, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1, 0, 0, 1, 0}, {
                0, 0, 1, 0, 1, 1, 1, 1, 0, 1}, {0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 0, 1}, {
                1, 0, 1, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};
        int i = new T130().numEnclaves(arr);
        System.out.println(i);
    }
}
