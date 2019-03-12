package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 字符串的排列 {
    public ArrayList<String> Permutation_125ms(String str) {
        if (str == null || "".equals(str)) return new ArrayList<String>();
        HashSet<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] flag = new boolean[str.length()];
        dfs_125ms(result, str, flag, sb);
        ArrayList<String> res = new ArrayList<>(result.size());
        for (String s : result) {
            res.add(s);
        }
        Collections.sort(res);
        return res;
    }

    private void dfs_125ms(HashSet<String> result, String str, boolean[] flag, StringBuilder sb) {
        if (sb.length() == str.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!flag[i]) {
                flag[i] = true;
                sb.append(str.charAt(i));
                dfs_125ms(result, str, flag, sb);
                sb.deleteCharAt(sb.length() - 1);
                flag[i] = false;
            }
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || "".equals(str)) return result;
        StringBuilder sb = new StringBuilder();
        boolean[] flag = new boolean[str.length()];
        dfs(result, str, flag, sb);
        Collections.sort(result);
        return result;
    }

    private void dfs(ArrayList<String> result, String str, boolean[] flag, StringBuilder sb) {
        if (sb.length() == str.length()) {
            String s = sb.toString();
            if (!result.contains(s)) result.add(s);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!flag[i]) {
                flag[i] = true;
                sb.append(str.charAt(i));
                dfs(result, str, flag, sb);
                sb.deleteCharAt(sb.length() - 1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> res = new 字符串的排列().Permutation("aa");
        System.out.println(res);
    }
}