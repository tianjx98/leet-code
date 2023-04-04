import java.util.HashSet;
import java.util.Scanner;

/**
 * 并查集
 * 处理不相交集合的合并及查询
 * https://blog.csdn.net/qq_41593380/article/details/81146850
 */
public class 合根植物 {
    /**
     * pre[i]记录了节点i的前导节点
     */
    private static int[] pre;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        pre = new int[m * n + 1];
        for (int i = 1; i <= n*m; i++) {
            pre[i] = i;
        }
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (find(x) != find(y)) {
                join(x,y);
            }
        }
        HashSet<Integer> roots = new HashSet<Integer>();
        for (int i = 1; i <= m * n; i++) {
            roots.add(find(i));
        }
        System.out.println(roots.size());

    }

    /**
     * 查找x的根节点
     *
     * @param x
     * @return
     */
    private static int find(int x) {
        /*
        int r = x;
        //找到x的根节点r,如果一个元素没有前导元素,就说明是根节点
        while (pre[r] != r)
            r = pre[r];
        //压缩路径
        int i = x, j;       //从x出发
        while (pre[i] != r) { //i的前导节点不是根节点
            j = pre[i];     //将i的前导节点保存
            pre[i] = r;     //将i的前导节点设为根节点
            i = pre[i];
        }
        return r;*/
        if (pre[x]==x) return x;
        return pre[x]=find(pre[x]);
    }

    /**
     * 如果x,y不连通, 就将x,y联通
     *
     * @param x
     * @param y
     */
    private static void join(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            pre[rx] = ry;
        }
    }
}
