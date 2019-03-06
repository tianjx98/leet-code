package 剑指offer;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<Integer>();

        int height = matrix.length, width = matrix[0].length;
        int count = height * width, c = 1;
        int direction = 1;// 移动的方向,1,2,3,4分别代表右,下,左,上
        int num = width;//移动次数
        int x = 0, y = -1;

        ArrayList<Integer> result = new ArrayList<>(width * height);
        while (c <= count) {
            for (int i = 0; i < num; i++) {
                if (direction == 1) y++; //向右
                else if (direction == 2) x++; //向下
                else if (direction == 3) y--; //向左
                else x--; //向上
                c++;
                result.add(matrix[x][y]);
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
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        ArrayList<Integer> integers = new 顺时针打印矩阵().printMatrix(arr);
        System.out.println(integers);
    }
}