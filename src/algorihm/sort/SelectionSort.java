package algorihm.sort;

public class SelectionSort extends Sort {
    /**
     * 选择排序，每次选择未排序数组中最小的元素放到最前面
     */
    @Override
    public void sort() {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[minIndex]) minIndex=j;
            }
            if (i==minIndex) continue;
            int t = arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=t;
        }
    }

    public static void main(String[] args) {
        new SelectionSort().sort();
    }
}
//https://mmbiz.qpic.cn/mmbiz_gif/D67peceibeISwc3aGibUlvZ0XqVnbWtBRiaB2dW1vA5SganRPChytYTFiaJL2PkXlL7XmhYmqIAzBHj0VvgJZs0vmA/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1