import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.BiFunction;

class Solution_Bfs {
    private static final int VISITED = 2, LAND_VALUE = 1;
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        BiFunction<Integer, Integer, Integer> bfs = (sourceRow, sourceCol) -> {
            grid[sourceRow][sourceCol] = VISITED;
            queue.offer(new int[]{sourceRow, sourceCol});
            int area = 1;
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int row = point[0], col = point[1];
                for (int[] dir : DIRS) {
                    int nextRow = row + dir[0], nextCol = col + dir[1];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n
                            || grid[nextRow][nextCol] != LAND_VALUE) {
                        continue;
                    }
                    grid[nextRow][nextCol] = VISITED;
                    queue.offer(new int[]{nextRow, nextCol});
                    area++;
                }
            }
            return area;
        };
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND_VALUE) {
                    maxArea = Math.max(maxArea, bfs.apply(i, j));
                }
            }
        }
        return maxArea;
    }
}