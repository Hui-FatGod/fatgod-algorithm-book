import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

class Solution_Dfs {
    private final static Integer NOT_CALCULATED_VALUE = null;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memory = new Integer[n][n];
        for (Integer[] row : memory) {
            Arrays.fill(row, NOT_CALCULATED_VALUE);
        }
        BiFunction<Integer, Integer, Integer> dfs = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
                if (i == n - 1) {
                    return triangle.get(n - 1).get(j);
                }
                if (memory[i][j] != NOT_CALCULATED_VALUE) {
                    return memory[i][j];
                }
                return memory[i][j] = Math.min(this.apply(i + 1, j), this.apply(i + 1, j + 1))
                        + triangle.get(i).get(j);
            }
        };
        return dfs.apply(0, 0);
    }
}