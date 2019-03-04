package 剑指offer;

public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        double num = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                num *= base;
            }
        } else {
            exponent = -exponent;
            for (int i = 0; i < exponent; i++) {
                num /= base;
            }
        }
        return num;
    }

    public double fastPower(double base, int exponent) {
        double num = 1;
        boolean isNeg = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNeg = true;
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1) num *= base;
            base *= base;
            exponent >>= 1;
        }
        return isNeg ? 1 / num : num;
    }

    public static void main(String[] args) {
        double power = new 数值的整数次方().fastPower(2.0, -10);
        System.out.println(power);
    }
}