package T101_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class _118_generate {
    /**
     * https://leetcode-cn.com/problems/pascals-triangle/
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows>=1) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            result.add(row);
        }
        if (numRows>=2) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            row.add(1);
            result.add(row);
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> preRow = result.get(i - 2);
            ArrayList<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 2; j < i ; j++) {
                row.add(preRow.get(j - 2) + preRow.get(j - 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new _118_generate().generate(33);
        for (List<Integer> list:triangle){
            System.out.println(list);
        }
    }
}