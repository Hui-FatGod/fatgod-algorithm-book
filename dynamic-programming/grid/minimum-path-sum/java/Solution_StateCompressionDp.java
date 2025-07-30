import java.util.Arrays;

class Solution_StateCompressionDp {
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int[] current = new int[n + 1];
        Arrays.fill(current, Integer.MAX_VALUE);
        current[1] = 0;
        for (int[] row : grid) {
            for (int i = 1; i <= n; i++) {
                current[i] = Math.min(current[i - 1], current[i]) + row[i - 1];
            }
        }
        return current[n];
    }
}