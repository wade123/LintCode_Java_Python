import java.util.ArrayList;

class NQueens {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

    ArrayList<ArrayList<String>> solveNQueens(int n) {
        int[] board = new int[n];
        dfs(new ArrayList<String>(), 0, board);
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

    void dfs(ArrayList<String> list, int row, int[] board) {
        if (row == board.length) {
            result.add(new ArrayList<String>(list));
        }
        for (int column = 0; column < board.length; column++) {
            if (checkCurrent(board, row, column)) {
                board[row] = column;
                list.add(print(board, column));
                dfs(list, row + 1, board);
                list.remove(row);
            }
        }

    }

    String print(int[] board, int column) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            if (i == column) {
                string.append('Q');
            } else {
                string.append('.');
            }
        }
        return string.toString();
    }

    public static void main(String[] args) {
        NQueens test = new NQueens();
        int n = 6;
        System.out.println(test.solveNQueens(n));
        //System.out.println(test.solveNQueens(n).size());
        System.out.println(test.result);
        System.out.println(test.result.size());
    }
}