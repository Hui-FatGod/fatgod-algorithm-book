import java.util.Arrays;
import java.util.function.BiFunction;

class Solution_Dfs {
    private static final Integer NOT_CALCULATED_VALUE = null;

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Integer[][] memory = new Integer[m][n];
        for (Integer[] row : memory) {
            Arrays.fill(row, NOT_CALCULATED_VALUE);
        }
        BiFunction<Integer, Integer, Integer> dfs = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
                if (j < 0 || j >= n) {
                    return Integer.MAX_VALUE;
                }
                if (i == 0) {
                    return matrix[0][j];
                }
                if (memory[i][j] != NOT_CALCULATED_VALUE) {
                    return memory[i][j];
                }
                return memory[i][j] = Math.min(Math.min(this.apply(i - 1, j - 1), this.apply(i - 1, j))
                        , this.apply(i - 1, j + 1)) + matrix[i][j];
            }
        };
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dfs.apply(m - 1, i));
        }
        return minSum;
    }
}