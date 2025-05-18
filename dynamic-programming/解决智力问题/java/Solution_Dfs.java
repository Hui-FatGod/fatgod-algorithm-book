import java.util.Arrays;
import java.util.function.Function;

class Solution_Dfs {
    private final static int NOT_CALC = -1;

    public long mostPoints(int[][] questions) {
        final int n = questions.length;
        final long[] memory = new long[n];
        Arrays.fill(memory, NOT_CALC);
        Function<Integer, Long> dfs = new Function<Integer, Long>() {
            @Override
            public Long apply(Integer i) {
                if (i >= n) {
                    return 0L;
                }
                if (i == n - 1) {
                    return (long) questions[n - 1][0];
                }
                if (memory[i] != NOT_CALC) {
                    return memory[i];
                }
                return memory[i] = Math.max(questions[i][0] + this.apply(i + questions[i][1] + 1)
                        , this.apply(i + 1));
            }
        };
        return dfs.apply(0);
    }
}