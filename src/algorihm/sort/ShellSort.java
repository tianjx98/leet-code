package algorihm.sort;

import java.util.ArrayList;

public class ShellSort extends Sort {
    /**
     * 将数组按一定增量跳跃分组，然后对每一组进行插入排序
     * https://www.cnblogs.com/chengxiao/p/6104371.html
     *
     * 普通希尔排序
     * gap=arr.length;
     * gap/=2;
     * 数组长度 1000 执行用时: 520 μs, 0 ms
     * 数组长度 10000 执行用时: 3279 μs, 3 ms
     * 数组长度 100000 执行用时: 16583 μs, 16 ms
     * 数组长度 1000000 执行用时: 261577 μs, 261 ms
     * 数组长度 10000000 执行用时: 5447526 μs, 5447 ms
     * 数组长度 100000000 执行用时: 78038324 μs, 78038 ms
     *
     * 优化。。
     * gap=1 5 19 41 109 209 505 929 2161 3905 8929
     * a(0)=1, a(1)=5, a(2)=19, a(3)=41, a(4)=109, a(n)=a(n-1)+6*a(n-2)- 6*a(n-3)- 8*a(n-4)+8*a(n-5)
     * 数组长度 1000 执行用时: 520 μs, 0 ms
     * 数组长度 10000 执行用时: 5355 μs, 5 ms
     * 数组长度 100000 执行用时: 17558 μs, 17 ms
     * 数组长度 1000000 执行用时: 229336 μs, 229 ms
     * 数组长度 10000000 执行用时: 3448816 μs, 3448 ms
     * 数组长度 100000000 执行用时: 42220444 μs, 42220 ms
     */
    @Override
    public void sort() {
        //common_sort();
        optimize();
    }

    private void optimize() {
        ArrayList<Integer> inc = new ArrayList<>();
        inc.add(1);
        inc.add(5);
        inc.add(19);
        inc.add(41);
        inc.add(109);
        int k = 0;
        for (int i = 0; i < 5; i++) {
            if (inc.get(k) < arr.length) k++;
        }
        while (k >= 5) {
            inc.add(inc.get(k - 1) + 6 * inc.get(k - 2) - 6 * inc.get(k - 3) - 8 * inc.get(k - 4) + 8 * inc.get(k - 5));
            if (inc.get(k) > arr.length) {
                break;
            }
            k++;
        }
        k--;
        while (k >= 0) {
            int gap = inc.get(k--);
            //每次分为gap个组，依次对每一组进行插入排序
            for (int n = 0; n < gap; n++) {
                for (int i = n + gap; i < arr.length; i += gap) {
                    int key = arr[i];
                    int j = i - gap;
                    while (j >= n && arr[j] > key) {
                        arr[j + gap] = arr[j];
                        j -= gap;
                    }
                    arr[j + gap] = key;
                }
            }
        }
    }

    private void common_sort() {
        //初始gap为数组一半，每次gap为上次的一半
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //每次分为gap个组，依次对每一组进行插入排序
            for (int n = 0; n < gap; n++) {
                for (int i = n + gap; i < arr.length; i += gap) {
                    int key = arr[i];
                    int j = i - gap;
                    while (j >= n && arr[j] > key) {
                        arr[j + gap] = arr[j];
                        j -= gap;
                    }
                    arr[j + gap] = key;
                }
            }
        }
    }

    public ShellSort(int[] arr, int range) {
        super(arr, range);
    }

    public ShellSort() {
    }

    public static void main(String[] args) {
        new ShellSort(new int[]{1000,10000,100000,1000000,10000000,100000000},Integer.MAX_VALUE).test();
    }
}
