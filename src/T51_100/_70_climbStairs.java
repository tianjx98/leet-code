package T51_100;

class _70_climbStairs {
    public int climbStairs(int n) {
        int a=1,b=2,c=0;
        if (n==1) return 1;
        if (n==2) return 2;
        for (int i = 3; i <= n; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String[] args) {
        int i = new _70_climbStairs().climbStairs(44);
        System.out.println(i);
    }
}