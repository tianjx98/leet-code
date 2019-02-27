package T251_300;

class _289_gameOfLife {
    private final int DEAD = 0;
    private final int LIVE = 1;

    /**
     * https://leetcode-cn.com/problems/game-of-life/
     * 周围活细胞数
     * <2   dead
     * 2||3 live
     * >3   dead
     * =3   dead->live
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int height=board.length;
        int width=board[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // TODO ...
            }
        }
    }
}