class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] seen = new int[board.length][board[0].length];

                    if (search(board, word, 1, i, j, seen)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word, int charId, int i, int j, int[][] seen) {
        if (charId >= word.length()) {
            return true;
        }

        seen[i][j] = 1;

        var c = word.charAt(charId);
        var up = i - 1;
        var down = i + 1;
        var right = j + 1;
        var left = j - 1;
        var nextChar = charId + 1;
        

        var res = (up >= 0 && seen[up][j] != 1 && board[up][j] == c && search(board, word, nextChar, up, j, seen)) ||
            (down < board.length && seen[down][j] != 1 && board[down][j] == c && search(board, word, nextChar, down, j, seen)) ||
            (right < board[i].length && seen[i][right] != 1 && board[i][right] == c && search(board, word, nextChar, i, right, seen)) ||
            (left >= 0 && seen[i][left] != 1 && board[i][left] == c && search(board, word, nextChar, i, left, seen));

        seen[i][j] = 0;

        return res;
    }
}
