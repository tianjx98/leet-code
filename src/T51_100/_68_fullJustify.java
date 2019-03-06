package T51_100;


import java.util.ArrayList;
import java.util.List;

class _68_fullJustify {
    /**
     * https://leetcode-cn.com/problems/text-justification/submissions/
     *
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(maxWidth);
        for (int i = 0; i < words.length; ) {
            int j = 0, wordLen = 0;
            for (; wordLen + j - 1 < maxWidth && i + j < words.length; j++) {
                wordLen += words[i + j].length();
            }
            if (wordLen + j - 1 > maxWidth) wordLen -= words[--j + i].length();
            int spaceNum = 0;
            int additionSpace = 0;
            if (j == 1) {
                spaceNum = maxWidth - wordLen;
            } else {
                spaceNum = (maxWidth - wordLen) / (j - 1);
                additionSpace = (maxWidth - wordLen) % (j - 1);
            }
            if (i + j == words.length) {
                spaceNum = 1;
                additionSpace = 0;
            }
            for (int k = 0; k < j; k++) {
                sb.append(words[i + k]);
                if (k != j - 1) makeSpace(sb, spaceNum + (additionSpace-- > 0 ? 1 : 0));
            }
            if (sb.length()<maxWidth) makeSpace(sb, maxWidth - sb.length());
            i += j;
            result.add(sb.toString());
            sb.setLength(0);
        }
        return result;
    }

    private void makeSpace(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }

    public static void main(String[] args) {
        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        List<String> list = new _68_fullJustify().fullJustify(words, 16);
        for (String s : list) {
            System.out.println(s);
        }
    }
}