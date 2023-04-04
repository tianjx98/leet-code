
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 大臣的旅费 {
    static class Node {
        int val;
        int len;

        public Node(int val, int len) {
            this.val = val;
            this.len = len;
        }

        @Override
        public String toString() {
            return "(" + val + "," + len + ")";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<LinkedList<Node>> graph = new ArrayList<LinkedList<Node>>(n + 1);
        graph.add(null);
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<Node>());
        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        //int maxIndex = bfs(graph, 1)[0];
        //int result = bfs(graph, maxIndex)[1];

        boolean[] flag = new boolean[graph.size()];
        dfs(graph, flag, 1, 0);
        dfs(graph, flag, maxIndex, 0);
        System.out.println(max * (21 + max) / 2);
    }

    private static int maxIndex = 0;
    private static int max = 0;

    private static void dfs(ArrayList<LinkedList<Node>> graph, boolean[] flag, int index, int len) {
        LinkedList<Node> nodes = graph.get(index);
        for (Node n : nodes) {
            flag[index] = true;
            if (flag[n.val]) continue;
            len += n.len;
            if (len > max) {
                max = len;
                maxIndex = n.val;
            }
            dfs(graph, flag, n.val, len);
            len -= n.len;
            flag[n.val] = false;
        }
    }

    private static int[] bfs(ArrayList<LinkedList<Node>> graph, int start) {
        boolean[] flag = new boolean[graph.size()];
        int[] lens = new int[graph.size()];
        flag[start] = true;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            LinkedList<Node> list = graph.get(node.val);
            for (Node n : list) {
                if (!flag[n.val]) {
                    flag[n.val] = true;
                    lens[n.val] += n.len + lens[node.val];
                    queue.add(n);
                }
            }
        }
        int maxIndex = 1;
        for (int i = 2; i < lens.length; i++) {
            if (lens[i] > lens[maxIndex]) {
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, lens[maxIndex]};
    }

}
