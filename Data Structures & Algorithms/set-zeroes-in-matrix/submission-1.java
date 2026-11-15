class Solution {
    public void setZeroes(int[][] matrix) {
        var n = matrix.length;
        var m = matrix[0].length;
        var firstRowZero = false;

        for (var i = 0; i < n; i ++) {
            for (var j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;

                        if (i > 0) {
                            matrix[i][0] = 0;
                        } else {
                            firstRowZero = true;
                        }
                    }
                }
            }
        }

        for (var i = 1; i < n; i++) {
            for (var j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 1; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRowZero) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
