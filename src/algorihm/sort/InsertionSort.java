package algorihm.sort;

public class InsertionSort extends Sort {
    /**
     * 插入排序,默认从小到大排序
     * 从第二个数n开始遍历,找n前面比n小的数m,把m后面n之前的数往后挪一位,
     * 然后把n插到m后面一位
     *
     * <p>
     * 测试
     * 10000    16ms
     * 100000   1131ms
     *
     */
    @Override
    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i]; //从第二个数开始
            //如果前面的数比这个数大,就把前面的数往后挪,直到找到一个比这个数小的数
            while (j >= 0 && (arr[j] > key)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
//https://mmbiz.qpic.cn/mmbiz_gif/D67peceibeISwc3aGibUlvZ0XqVnbWtBRiaiatKZU4exjwcluduiclJOdZB0oZQicCrpIEaSJJg8iaia58viauSK3nhofqA/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
