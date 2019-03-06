package 剑指offer;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] array) {
        int[] tmp = new int[array.length];
        int j = 0, k = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                array[j++]=array[i];
            } else tmp[k++]=array[i];
        }
        System.arraycopy(tmp, 0, array, j, k);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        new 调整数组顺序使奇数位于偶数前面().reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}