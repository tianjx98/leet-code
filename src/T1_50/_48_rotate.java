package T1_50;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/grandyang/p/4389572.html
 * 1.每次循环换四个数字
 * 2.首先以从对角线为轴翻转，然后再以x轴中线上下翻转即可得到结果
 */
class _48_rotate {
    /**
     * https://leetcode-cn.com/problems/rotate-image/
     *
     * 对每一层四个方向依次进行翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;// 阶数
        int layerNum = n / 2; // 层数,有多少层就要循环多少次
        for (int layer = 0; layer < layerNum; layer++) {
            int moveNum = n - (2 * layer + 1);// 对应层数移动元素的个数
            int[] tmp = new int[moveNum]; // 存储开始被覆盖的元素
            int fromX = layer + 1;// 第几个数组
            int fromY = n - layer - 1;// 数组中第几个元素
            for (int i = 0; i < moveNum; i++) { // 复制到tmp中
                tmp[i] = matrix[fromX + i][fromY];
            }
            // 调整x,fromY
            fromX = layer;
            fromY = layer + 1;
            int toX = layer + 1;
            int toY = n - layer - 1;
            for (int j = 0; j < moveNum; j++) {
                matrix[toX + j][toY] = matrix[fromX][fromY + j];
            }

            fromX = n - layer - 2;
            fromY = layer;
            toX = layer;
            toY = layer + 1;
            for (int j = 0; j < moveNum; j++) {
                matrix[toX][toY + j] = matrix[fromX - j][fromY];
            }

            fromX = n - layer - 1;
            fromY = n - layer - 2;
            toX = n - layer - 2;
            toY = layer;
            for (int j = 0; j < moveNum; j++) {
                matrix[toX - j][toY] = matrix[fromX][fromY - j];
            }

            toX = fromX;
            toY = fromY;
            for (int i = 0; i < moveNum; i++) {
                matrix[toX][toY - i] = tmp[i];
            }
        }
    }

    void  rotate_(int[][] matrix){
        if (matrix==null||matrix.length==0) return;
        int n=matrix.length;
        int layerNum=n/2;
        for (int i = 0; i < layerNum; i++) {
            for (int j = i; j < n-i-1; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmp;
            }
        }
    }

    void rotate_1ms(int[][] matrix) {
        int n = matrix.length;
        if (n <= 0) {
            return;
        }
        int m = n - 1;
        for (int i = 0; i <= m / 2; i++) {
            for (int j = i; j < m - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[m - j][i];
                matrix[m - j][i] = matrix[m - i][m - j];
                matrix[m - i][m - j] = matrix[j][m - i];
                matrix[j][m - i] = t;
            }
        }
    }

    private static void print(int[][] arr) {
        System.out.println("---------------------");
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
//        int[][] arr={
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
        int[][] arr = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new _48_rotate().rotate_(arr);
        print(arr);
    }
}