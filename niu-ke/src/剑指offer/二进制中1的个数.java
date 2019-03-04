package 剑指offer;

public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n=-1;
        int i = new 二进制中1的个数().NumberOf1(n);
    }
}