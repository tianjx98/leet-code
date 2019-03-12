package 剑指offer;

public class 跳台阶 {
    public int JumpFloor(int target) {
        int count = 0;
        for (int i=0; i <= (target/2); i++) {//i为跳二阶的次数
            count += combination(i, target-i);
        }
        return count;
    }

    /**
     * n中取m个求排列组合
     * @param m
     * @param n
     * @return
     */
    private static long combination(int m, int n) {
        if (m==n) return 1;
        long c = 1;
        for (int i = 0; i < m; i++) {
            c = c * (n - i) / (i + 1);
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 44;
        int i = new 跳台阶().JumpFloor(n);
        System.out.println(i);
    }
}