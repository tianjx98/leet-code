package solutions;

import java.util.*;
import java.util.stream.Collectors;

class _1233_removeSubfolders {
    public List<String> removeSubfolders(String[] folder) {
        if (folder.length < 2) {
            return Arrays.asList(folder);
        }
        final Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        final int len = 27;
        final int maxLen = getMaxFolderLength(folderSet);
        final boolean[][] flag = new boolean[maxLen][len];
        //final boolean[] isTail = new boolean[maxLen - 1];
        for (String s : folder) {
            int i = 1;
            boolean isExist = true;
            for (; i < s.length(); i++) {
                final char ch = s.charAt(i);
                if ('/' == ch) {
                    if (flag[i - 1][len - 1] && isExist) {
                        folderSet.remove(s);
                        break;
                    }
                    continue;
                }
                isExist = flag[i - 1][ch - 'a'];
                flag[i - 1][ch - 'a'] = true;
            }
            flag[s.length() - 1][len - 1] = true;
            //isTail[i - 1] = true;
        }
        return new ArrayList<>(folderSet);
    }

    private int getMaxFolderLength(Set<String> folders) {
        int len = 0;
        for (String folder : folders) {
            if (folder.length() > len) {
                len = folder.length();
            }
        }
        return len;
    }

    public static void main(String[] args) {
        final String[] strings = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        final List<String> list = new _1233_removeSubfolders().removeSubfolders(strings);
        System.out.println(list);
    }
}