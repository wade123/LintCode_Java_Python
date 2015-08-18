class NQueensTwo {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int result = 0;

    public int totalNQueens(int n) {
        int[] board = new int[n];
        dfs(0, board);
        return result;
    }

    boolean checkCurrent(int[] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i] == column || (row - i) == Math.abs(column - board[i])) {
                return false;
            }
        }
        return true;
    }

    void dfs(int row, int[] board) {
        if (row == board.length) {
            result++;
        }
        for (int column = 0; column < board.length; column++) {
            if (checkCurrent(board, row, column)) {
                board[row] = column;
                dfs(row + 1, board);
            }
        }

    }

    public static void main(String[] args) {
        NQueensTwo test = new NQueensTwo();
        int n = 10;
        System.out.println(test.totalNQueens(n));
    }
}