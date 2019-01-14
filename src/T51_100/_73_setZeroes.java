package T51_100;

import java.util.Arrays;
import java.util.HashSet;

class _73_setZeroes {
    /**
     * https://leetcode-cn.com/problems/set-matrix-zeroes/
     *
     * 第一次遍历,将为零的数的行数放到一个set中,列数放到另一个set中
     * 第二次遍历,将行号或者列号在对应set中的数置零
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row=new HashSet<>();
        HashSet<Integer> col=new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row.contains(i)||col.contains(j)) {
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr={
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        new _73_setZeroes().setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}