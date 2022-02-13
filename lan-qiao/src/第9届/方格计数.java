package 第9届;

public class 方格计数 {
    public static void main(String[] args) {
        double radius = 1000;
        int count = 0;
        for (int x = 1; x < 1000; x++) {
            for (int y = 1; y < 1000; y++) {
                if (Math.sqrt(x * x + y * y) <= radius) {
                    count++;
                }
            }
        }
        System.out.println(count * 4);
    }
}
//3137548