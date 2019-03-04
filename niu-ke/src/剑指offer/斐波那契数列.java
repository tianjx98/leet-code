package 剑指offer;

public class 斐波那契数列 {
    public int Fibonacci(int n) {
        if (n==0) return 0;
        if (n==1||n==2) return 1;
        int pre=1,next=1,t;
        for (int i = 2; i < n; i++) {
            t=pre+next;
            pre=next;
            next=t;
        }
        return next;
    }

    public static void main(String[] args) {
        int fibonacci = new 斐波那契数列().Fibonacci(5);
        System.out.println(fibonacci);
    }
}