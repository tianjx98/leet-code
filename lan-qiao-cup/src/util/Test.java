package util;

import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph[a][b] = c;
            graph[b][a] = c;
        }
        //boolean[] flag = new boolean[n + 1];
        int maxNode = bfs(graph, 1)[0];
        int maxLen = bfs(graph, maxNode)[1];
        //dfs(graph, flag, maxNode, 0);
        System.out.println(maxLen*10+maxLen*(1+maxLen)/2);
    }

    private static int MAX_LEN = 0;

    private static void dfs(int[][] graph, boolean[] flag, int start, int distance) {
        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] > 0) {
                if (!flag[i]) {
                    flag[i] = true;
                    distance += graph[start][i];
                    if (distance > MAX_LEN) MAX_LEN = distance;
                    dfs(graph, flag, i, distance);
                    distance -= graph[start][i];
                    flag[i] = false;
                }
            }
        }
    }

    private static int[] bfs(int[][] graph, int start) {
        int[] len = new int[graph.length];
        boolean[] flag = new boolean[graph.length];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        flag[start] = true;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < graph[n].length; i++) {
                if (graph[n][i] > 0) {
                    if (!flag[i]) {
                        flag[i] = true;
                        len[i] += graph[n][i] + len[n];
                        queue.add(i);
                    }
                }
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < len.length; i++) {
            if (len[i] > len[maxIndex]) {
                maxIndex = i;
            }
        }
        return new int[]{maxIndex,len[maxIndex]};
    }
}
