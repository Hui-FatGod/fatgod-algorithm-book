import java.util.Arrays;

class Solution_StateCompressionDp {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] current = new int[n + 1];
        Arrays.fill(current, Integer.MAX_VALUE);
        current[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                current[j] = Math.max(Math.min(current[j], current[j + 1]) - dungeon[i][j], 1);
            }
        }
        return current[0];
    }
}