import java.util.Arrays;
import java.util.function.BiFunction;

class Solution_Dfs {
    private static final int NOT_CALCULATED_VALUE = -1;

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memory = new int[m][n];
        for (int[] row : memory) {
            Arrays.fill(row, NOT_CALCULATED_VALUE);
        }
        BiFunction<Integer, Integer, Integer> dfs = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
                if (i < 0 || j < 0) {
                    return Integer.MAX_VALUE;
                }
                if (i == 0 && j == 0) {
                    return grid[0][0];
                }
                if (memory[i][j] != NOT_CALCULATED_VALUE) {
                    return memory[i][j];
                }
                return memory[i][j] = Math.min(this.apply(i - 1, j), this.apply(i, j - 1)) + grid[i][j];
            }
        };
        return dfs.apply(m - 1, n - 1);
    }
}