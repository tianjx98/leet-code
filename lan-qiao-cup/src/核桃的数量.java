import java.util.Arrays;
import java.util.Scanner;

public class 核桃的数量 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        nums[0] = scanner.nextInt();
        nums[1] = scanner.nextInt();
        nums[2] = scanner.nextInt();
        Arrays.sort(nums);
        while (true) {
            if (nums[2] % nums[0] == 0 && nums[2] % nums[1] == 0) break;
            nums[2]+=nums[2];
        }
        System.out.println(nums[2]);
    }
}
