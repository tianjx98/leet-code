package T51_100;

import java.util.Arrays;

class _74_searchMatrix {
    /**
     * https://leetcode-cn.com/problems/search-a-2d-matrix/
     *
     * 先找到一行,这一行的第一个数比target小,最后一个数比target大
     * 然后在这一行使用二分查找,找到返回true,找不到返回false
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int i = 0;
        for (; i < matrix.length; i++) {
            if (target<matrix[i][0]) return false;
            if (target<=matrix[i][matrix[i].length-1]) break;
        }
        if (i>=matrix.length) return false;
        return Arrays.binarySearch(matrix[i],target)>=0;
    }
    public boolean searchMatrix_6ms(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int xStart = 0;
        int yStart = matrix.length - 1;
        while( xStart <= matrix[0].length - 1 && yStart >= 0 ) {
            if( target > matrix[yStart][xStart] ){
                xStart++;
            }else if( target < matrix[yStart][xStart]){
                yStart--;
            }else{
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
//        int[][] arr={
//                {1,   3,  5,  7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        };
        int[][] arr={
                {1}
        };
        boolean searchMatrix = new _74_searchMatrix().searchMatrix(arr, 16);
        System.out.println(searchMatrix);
    }
}