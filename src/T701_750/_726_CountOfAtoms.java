package T701_750;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/number-of-atoms/
 */
class _726_CountOfAtoms {
    private Map<String, Integer> atoms = new HashMap<>();
    public String countOfAtoms(String formula) {
        final char[] chs = formula.toCharArray();
        return countAtoms(chs, 0, chs.length);
    }

    private String countAtoms(char[] chs, int start, int end) {
        if ('(' == chs[start]) {
            countAtoms(chs, start + 1, end);
        }
        final HashMap<String, Integer> innerAtoms = new HashMap<>();
        int atomStart = start;
        int i = 1;
        for (; i < end && Character.isLowerCase(chs[atomStart + i]); i++) {

        }
        String atom = new String(chs, atomStart, start);
        final Integer atomCount = innerAtoms.get(atom);
        innerAtoms.put(atom, atomCount == null ? 1 : atomCount + 1);
    }

}