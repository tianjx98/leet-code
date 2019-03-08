import java.util.ArrayList;
import java.util.Scanner;

/**
 * 带权树最长路径
 */
public class 大臣的旅费 {
    private static int maxLen = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] len = new int[n + 1][n + 1];
        ArrayList<ArrayList<Integer>> road = new ArrayList<ArrayList<Integer>>(n + 1);
        road.add(null);
        for (int i = 0; i < n; i++) {
            road.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            len[a][b] = c;
            len[b][a] = c;
            road.get(a).add(b);
            road.get(b).add(a);
        }
        boolean[] flag = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dfs(len, road, flag, i, 0);
        }
        System.out.println(maxLen*10+maxLen*(1+maxLen)/2);
    }

    private static void dfs(int[][] len, ArrayList<ArrayList<Integer>> road, boolean[] flag, int city, int distance) {
        ArrayList<Integer> to = road.get(city);
        for (int i = 0; i < to.size(); i++) {
            int toCity = to.get(i);
            if (flag[toCity]) continue;
            flag[city] = true;
            distance += len[city][toCity];
            if (distance > maxLen) maxLen = distance;
            dfs(len, road, flag, toCity, distance);
            distance -= len[city][toCity];
            flag[city] = false;
        }
    }
}
