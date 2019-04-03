package algorihm.sort;

public class BubbleSort extends Sort {
    /**
     * 冒泡排序,默认从小到大排序
     * <p>
     * 比较相邻的元素，如果第一个比第二个大，就交换他们两个，第一次循环后最后一个元素为最大元素
     * 第一次比较n-1次，第二次比较n-2次，依次减少，到最后一次时排序完成
     * <p>
     * 优化：
     * 每一次比较前设置一个标记，如果当比较完成之后都没有进行交换，就说明已经排序完成
     */
    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            //设定一个标记，如果为true，则表示此次循环没有交换，排序已经完成
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }
}
//https://mmbiz.qpic.cn/mmbiz_gif/D67peceibeISwc3aGibUlvZ0XqVnbWtBRiaC1S2jpXRzXcZVn0aP6BYnkO2FJicNstxicHmf9wMIic5FV0I75ptv5jYA/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1