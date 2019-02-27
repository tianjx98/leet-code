package 剑指offer;

import java.util.Arrays;

public class 二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        if (array==null||array.length==0||array[0].length==0) return false;
        int row=array.length;
        int col=array[0].length;
        for (int i = 0; i < row; i++) {
            if (array[i][0] <= target) {
                if (array[i][col-1] >= target) {//在当前行
                    if (Arrays.binarySearch(array[i], 0, col, target) >= 0) {
                        return true;
                    }
                }
            } else break;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean find = new 二维数组中的查找().Find(3, arr);
        System.out.println("当前类:剑指offer.二维数组中的查找.main() 第21行:find值=" + find);
    }
}