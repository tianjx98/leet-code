package T51_100;

class _79_exist {
    /**
     * https://leetcode-cn.com/problems/word-search/
     * <p>
     * 先创建一个与字母表相同大小的二维数组来标记对应位置的字母是否被使用过
     * 先找到与字符串第一个字母相同的位置
     * 从这个位置开始回溯
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board.length * board[0].length < word.length()) return false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        Character first = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (first.equals(board[i][j])) {
                    if (backTrack(board, isVisited, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, boolean[][] isVisited, int x, int y, String word, int index) {
        if (index == word.length()) return true;// index和字符串长度相同,说明已经找到
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) return false;// 确保不会越界
        if (isVisited[x][y]) return false; //如果访问过直接返回false
        if (!((Character) word.charAt(index)).equals(board[x][y])) return false; //如果不同直接返回
        isVisited[x][y] = true;//设置该点已经使用
        //上下左右四个方向进行判断
        boolean result = backTrack(board, isVisited, x - 1, y, word, index + 1) ||
                backTrack(board, isVisited, x + 1, y, word, index + 1) ||
                backTrack(board, isVisited, x, y - 1, word, index + 1) ||
                backTrack(board, isVisited, x, y + 1, word, index + 1);
        isVisited[x][y] = false;//将访问点还原
        return result;
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean exist = new _79_exist().exist(arr, "ABCE");
        System.out.println(exist);
    }
}