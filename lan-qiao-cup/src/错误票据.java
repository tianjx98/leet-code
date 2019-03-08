import java.util.*;

public class 错误票据 {
    private static void find(List<Integer> list) {
        System.out.println("当前类:错误票据.find() 第5行:list值=" + list);
        int i = list.get(0);
        int lackNum = -1, repNum = -1;
        for (int j = 0; j < list.size(); j++,i++) {
            int n = list.get(j);
            if (n > i) {//缺失i-1
                lackNum = n - 1;
                i++;
            } else if (n < i) {
                repNum = n;
                i--;
                if (lackNum != -1 && repNum != -1) break;
            }
        }
        System.out.println(lackNum + " " + repNum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (row-- > 0) {
            String[] nums = scanner.nextLine().split(" ");
            for (String i : nums) {
                list.add(Integer.parseInt(i));
            }
        }
        Collections.sort(list);
        find(list);
    }
}
