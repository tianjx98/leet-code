package algorihm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public static void main(String[] args) {
        int[][] arr = {
                {},
                {2, 5},
                {1, 6},
                {6, 7, 4},
                {3, 7, 8},
                {1},
                {2, 3, 7},
                {3, 4, 6, 8},
                {4, 7},
        };
        ArrayList<LinkedList<Integer>> graph = makeGraph(arr);
        bfs(graph, 2);
    }

    /**
     * 广度优先搜索
     *
     * @param graph
     * @param node
     */
    private static void bfs(ArrayList<LinkedList<Integer>> graph, int node) {
        //创建一个数组来标记节点是否被访问过
        boolean[] flag = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            LinkedList<Integer> nodes = graph.get(n);
            for (Integer i : nodes) {
                if (!flag[i]) {
                    flag[i] = true;
                    System.out.println(i);
                    queue.add(i);
                }
            }
        }
    }

    /**
     * 根据数组构建邻接链表,元素从1开始
     *
     * @param arr
     * @return
     */
    private static ArrayList<LinkedList<Integer>> makeGraph(int[][] arr) {
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> node = new LinkedList<>();
            for (int j = 0; j < arr[i].length; j++) {
                node.add(arr[i][j]);
            }
            graph.add(node);
        }
        return graph;
    }
}
