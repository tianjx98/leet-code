package 第5届;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 扑克序列 {
    public static void main(String[] args) {
        char[] chars = {'A', 'A', '2', '2', '3', '3', '4', '4'};
        boolean[] flag = new boolean[chars.length];
        StringBuilder sb = new StringBuilder(chars.length);
        ArrayList<String> strings = new ArrayList<String>();
        //dfs(chars, flag, sb, strings);
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : chars) {
            Integer i = map.get(c);
            map.put(c, i == null ? 1 : i + 1);
        }

        dfs2(strings, map, sb, chars.length);
        find(strings);
    }

    private static void dfs2(ArrayList<String> strings, HashMap<Character, Integer> map, StringBuilder sb, int length) {
        if (sb.length() == length) {
            strings.add(sb.toString());
            return;
        }
        for (Character c : map.keySet()) {
            Integer val = map.get(c);
            if (val == 0) continue;
            map.put(c, val - 1);
            sb.append(c);
            dfs2(strings, map, sb, length);
            sb.deleteCharAt(sb.length() - 1);
            map.put(c, val);
        }
    }

    private static void find(ArrayList<String> strings) {
        Collections.sort(strings);
        for (String s : strings) {
            int firstA = s.indexOf('A');
            int lastA = s.lastIndexOf('A');
            if (lastA - firstA != 2) continue;

            int first2 = s.indexOf('2');
            int last2 = s.lastIndexOf('2');
            if (last2 - first2 != 3) continue;

            int first3 = s.indexOf('3');
            int last3 = s.lastIndexOf('3');
            if (last3 - first3 != 4) continue;

            int first4 = s.indexOf('4');
            int last4 = s.lastIndexOf('4');
            if (last4 - first4 != 5) continue;

            System.out.println(s);
        }
    }

    private static void dfs(char[] chars, boolean[] flag, StringBuilder sb, ArrayList<String> strings) {
        if (sb.length() == chars.length) {
            strings.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                sb.append(chars[i]);
                dfs(chars, flag, sb, strings);
                sb.deleteCharAt(sb.length() - 1);
                flag[i] = false;
            }
        }
    }
}
