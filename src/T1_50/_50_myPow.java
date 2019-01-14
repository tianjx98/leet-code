package T1_50;

class _50_myPow {
    /**
     * https://leetcode-cn.com/problems/powx-n/
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 1) return 1;
        if (x == -1) return n % 2 == 0 ? 1 : -1;
        if (n == 0) return 1;
        if (n == -Integer.MIN_VALUE) return 0.0;
        return n > 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (x == 1) return 1;
        double res = 1.0;
        for (int i = 0; i < n; i++) {
            res *= x;
            if (Double.isInfinite(res) || res == 0) return res;
        }
        return res;
    }

    public static void main(String[] args) {
        double pow = new _50_myPow().myPow(0.00001, Integer.MAX_VALUE);
        System.out.println(pow);
    }
}