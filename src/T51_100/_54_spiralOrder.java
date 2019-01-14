package T51_100;

import java.util.ArrayList;
import java.util.List;

class _54_spiralOrder {
    /**
     * https://leetcode-cn.com/problems/spiral-matrix/
     *
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();
        int height=matrix.length,width=matrix[0].length;
        int n=height*width;
        List<Integer> result = new ArrayList<Integer>(n);
        int direction=1;// 移动的方向,1,2,3,4分别代表右,下,左,上
        int num=width;
        int x=0,y=-1;
        while (result.size()<n) {
            for (int i = 0; i < num; i++) {
                if (direction==1) y++; //向右
                else if (direction==2) x++; //向下
                else if (direction==3) y--; //向左
                else x--; //向上
                result.add(matrix[x][y]);
            }
            if (direction==1) {
                direction=2;
                num=--height;
            } else if (direction==2) {
                direction=3;
                num=--width;
            } else if (direction==3) {
                direction=4;
                num=--height;
            } else {
                direction=1;
                num=--width;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] arr={
//                { 1, 2, 3 },
//                { 4, 5, 6 },
//                { 7, 8, 9 }
//        };
        int[][] arr={
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        List<Integer> list = new _54_spiralOrder().spiralOrder(arr);
        System.out.println(list.toString());
    }
}