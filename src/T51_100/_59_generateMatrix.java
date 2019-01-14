package T51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _59_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int height = n, width = n;
        int count = n * n, c = 1;
        int direction = 1;// 移动的方向,1,2,3,4分别代表右,下,左,上
        int num = width;
        int x = 0, y = -1;
        while (c <= count) {
            for (int i = 0; i < num; i++) {
                if (direction == 1) y++; //向右
                else if (direction == 2) x++; //向下
                else if (direction == 3) y--; //向左
                else x--; //向上
                matrix[x][y] = c++;
            }
            if (direction == 1) {
                direction = 2;
                num = --height;
            } else if (direction == 2) {
                direction = 3;
                num = --width;
            } else if (direction == 3) {
                direction = 4;
                num = --height;
            } else {
                direction = 1;
                num = --width;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new _59_generateMatrix().generateMatrix(2);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}