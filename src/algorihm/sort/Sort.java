package algorihm.sort;

import util.Timer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public abstract class Sort {
    private static final Random random=new Random();
    //存储测试用例大小
    private int[] testNum={1000,10000,100000};
    private int range=Integer.MAX_VALUE;
    //存储测试数组
    protected int[] arr = {8,9,1,7,2,3,5,4,6,0};

    public abstract void sort();

    /**
     * 设置测试量
     * 例如{100,1000}就会进行数组大小100和1000的测试
     * @param testNums  存放测试数组的大小
     */
    public Sort(int[] testNums,int range) {
        this.testNum=testNums;
        this.range=range;
    }

    /**
     * 默认测试量为1000,10000,100000
     */
    public Sort(){}

    protected void print(){
        System.out.println(Arrays.toString(arr));
    }

    public void test() {
        for (int i = 0; i < testNum.length; i++) {
            generateTestArray(testNum[i]);
            int[] copy=arr.clone();

            long time=System.nanoTime();
            sort();
            time=System.nanoTime()-time;

            Arrays.sort(copy);
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]!=copy[i]){
                    System.out.println("排序错误");
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(copy));
                    return;
                }
            }
            System.out.println("数组长度 "+testNum[i]+" 执行用时: " + time / 1000 + " μs, " + time / 1000000 + " ms");
        }
    }

    protected void generateTestArray(int n){
        arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=random.nextInt(range);
        }
    }

    /**
     * 在一个区间中选一个数作为基准数,然后使其左边的数都比它小,右边的数都比他大,
     * 形成两个子区间,然后再对这两个区间继续以上操作,直到区间不可再分,完成排序
     *
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
                arr[i] = arr[j];
                while (i < j && arr[i] <= flag) {
//                    if (arr[i] > flag) break;
                    i++;
                }
                arr[j] = arr[i];
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
     * <p>
     * 1.先找到一个基准数n(一般位区间第一个数)
     * 2.从区间后往前(j--)找到一个比n小的数
     * 3.从区间前往后(i++)找到一个比n大的数
     * 4.然后交换这两个数的位置,重复2,3步骤直到i==j
     * 5.将基准数n与i(j)处的数交换位置(这个时候i前面的数都比它小,后面的都比它大)
     * <p>
     * 6.将区间设置为 start~i-1 重复1-5步骤
     * 7.将区间设置为 i+1~end 重复1-5步骤
     * <p>
     * 测试
     * 10000    2ms
     * 100000   22ms
     *
     * @param arr     要排序的数组
     * @param reverse 是否从大到小排序
     */
    public static void quickSort(int[] arr, boolean reverse) {
        partSort(arr, 0, arr.length - 1);
        if (reverse) {
            int tmp;
            for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}
