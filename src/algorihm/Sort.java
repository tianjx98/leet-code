package algorihm;

import util.Timer;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void test() {
    }

    public static void main(String[] args) {
        final int num = 100000;
        int[] arr = new int[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            arr[i] = random.nextInt(10000);
        }
        int[] arr2 = arr.clone();
//        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8,3};

//        Timer.start();
//        Arrays.sort(arr2);
//        Timer.end();

        Timer.start();
        quickSort(arr, false);
        Timer.end();
//        Timer.start();
//        insertionSort(arr2,true);
//        Timer.end();

        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 冒泡排序,默认从小到大排序
     * <p>
     * 测试
     * 10000    206ms
     * 100000   9213ms
     *
     * @param arr     要排序的数组
     * @param reverse 是否从大到小排序
     */
    public static void bubbleSort(int[] arr, boolean reverse) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] > arr[j]) ^ reverse) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 插入排序,默认从小到大排序
     * 从第二个数n开始遍历,找n前面比n小的数m,把m后面n之前的数往后挪一位,
     * 然后把n插到m后面一位
     * <p>
     * 测试
     * 10000    16ms
     * 100000   1131ms
     *
     * @param arr     要排序的数组
     * @param reverse 是否从大到小排序
     */
    public static void insertionSort(int[] arr, boolean reverse) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i]; //从第二个数开始
            //如果前面的数比这个数大,就把前面的数往后挪,直到找到一个比这个数小的数
            while (j >= 0 && (arr[j] > key) ^ reverse) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 在一个区间中选一个数作为基准数,然后使其左边的数都比它小,右边的数都比他大,
     * 形成两个子区间,然后再对这两个区间继续以上操作,直到区间不可再分,完成排序
     * @param arr   目标数组
     * @param start 开始下标
     * @param end   结束下标(end指向区间的最后一个元素)
     */
    private static void partSort(int[] arr, int start, int end) {
        int i = start, j = end;
        if (i < j) {
            int flag = arr[i];
            while (i < j) {
                //两个while里面要有一个要带<=,不然报错
                while (i < j && arr[j] >= flag) {
//                    if (arr[j] < flag) break;
                    j--;
                }
                arr[i]=arr[j];
                while (i < j && arr[i] <= flag) {
//                    if (arr[i] > flag) break;
                    i++;
                }
                arr[j]=arr[i];
//                int tmp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = tmp;
            }
//            arr[start] = arr[i];
            arr[i] = flag;
            partSort(arr, start, i - 1);
            partSort(arr, i + 1, end);
        }
    }

    /**
     * 快速排序
     *
     * 1.先找到一个基准数n(一般位区间第一个数)
     * 2.从区间后往前(j--)找到一个比n小的数
     * 3.从区间前往后(i++)找到一个比n大的数
     * 4.然后交换这两个数的位置,重复2,3步骤直到i==j
     * 5.将基准数n与i(j)处的数交换位置(这个时候i前面的数都比它小,后面的都比它大)
     *
     * 6.将区间设置为 start~i-1 重复1-5步骤
     * 7.将区间设置为 i+1~end 重复1-5步骤
     *
     * 测试
     * 10000    2ms
     * 100000   22ms
     * @param arr     要排序的数组
     * @param reverse 是否从大到小排序
     */
    public static void quickSort(int[] arr, boolean reverse) {
        partSort(arr, 0, arr.length - 1);
        if(reverse){
            int tmp;
            for (int i=0,j=arr.length-1;i<j;i++,j--){
                tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }
    }
}
