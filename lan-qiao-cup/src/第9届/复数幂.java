package 第9届;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

public class 复数幂 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream("work.txt"));
        System.setOut(printStream);
        BigInteger a = new BigInteger("2");
        BigInteger b  = new BigInteger("3");
        BigInteger c = new BigInteger("2");
        BigInteger d = new BigInteger("3");
        BigInteger aa = new BigInteger("3");
        BigInteger bb = new BigInteger("3");
        for (int i = 1; i < 123456; i++) {
            aa = a.multiply(c).subtract(b.multiply(d));//
            bb = a.multiply(d).add(b.multiply(c));
            a=aa;
            b=bb;
        }
        System.out.println(a.toString() + (b.signum() > 0 ? "+" : "") + b.toString() + "i");
    }
}
