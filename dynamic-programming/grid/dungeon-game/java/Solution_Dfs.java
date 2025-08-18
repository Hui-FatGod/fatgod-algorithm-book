import java.util.Arrays;
import java.util.function.BiFunction;

class Solution_Dfs {
    private static final int NOT_CALCULATED_VALUE = -1;

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] memory = new int[m][n];
        for (int[] row : memory) {
            Arrays.fill(row, NOT_CALCULATED_VALUE);
        }
        BiFunction<Integer, Integer, Integer> dfs = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
                if (i >= m || j >= n) {
                    return Integer.MAX_VALUE;
                }
                if (i == m - 1 && j == n - 1) {
                    return Math.max(1 - dungeon[m - 1][n - 1], 1);
                }
                if (memory[i][j] != NOT_CALCULATED_VALUE) {
                    return memory[i][j];
                }
                return memory[i][j] = Math.max(Math.min(this.apply(i + 1, j), this.apply(i, j + 1))
                        - dungeon[i][j], 1);
            }
        };
        return dfs.apply(0, 0);
    }
}