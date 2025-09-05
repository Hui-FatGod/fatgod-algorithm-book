import java.util.function.BiFunction;

class Solution_Dfs {
    private static final int VISITED = 2, LAND_VALUE = 1;
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        BiFunction<Integer, Integer, Integer> dfs = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer row, Integer col) {
                if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != LAND_VALUE) {
                    return 0;
                }
                grid[row][col] = VISITED;
                int area = 1;
                for (int[] dir : DIRS) {
                    area += this.apply(row + dir[0], col + dir[1]);
                }
                return area;
            }
        };
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND_VALUE) {
                    maxArea = Math.max(maxArea, dfs.apply(i, j));
                }
            }
        }
        return maxArea;
    }
}