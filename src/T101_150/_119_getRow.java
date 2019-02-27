package T101_150;

import java.util.ArrayList;
import java.util.List;

class _119_getRow {
    /**
     * https://leetcode-cn.com/problems/pascals-triangle-ii/submissions/
     *
     * 在一行中循环生成到第n行
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(++rowIndex);
        result.add(1);
        if (rowIndex==1) {
            return result;
        }
        result.add(1);
        for (int i = 2; i < rowIndex; i++) {
            int p,q=result.get(0);
            for (int j = 1; j < i; j++) {
                p=q;
                q=result.get(j);
                result.set(j,p+q);
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> row = new _119_getRow().getRow(3);
        System.out.println("当前类:_119_getRow.main() 第25行:row值=" + row);
    }
}