package T1_50;

class _7_reverse {
    /**
     * https://leetcode-cn.com/problems/reverse-integer/
     *
     * 先记下这个数的符号,然后将其变为正数
     * 然后将其最后一位依次加入StringBuffer
     * 将形成的字符串转化为数字,转化过程中可能出现溢出现象,用try-catch捕获
     * 返回结果时是负数就加上负号
     * @param x
     * @return
     */
    public int reverse(long x) {
        boolean isNeg = false; // 默认不是负数
        if (x < 0) {
            isNeg = true;
            x = -x;
        }
        StringBuffer sb = new StringBuffer(10);
        while (x != 0) {
            sb.append(x % 10);
            x /= 10;
        }
        int result = 0;
        if (sb.length() != 0) {
            try {
                result = Integer.parseInt(sb.toString());
            }catch (Exception e){
                ;
            }
        }
        return isNeg ? -result : result;
    }

    public static void main(String[] args) {
        int reverse = new _7_reverse().reverse(1744646848);
        System.out.println(reverse);
    }
}