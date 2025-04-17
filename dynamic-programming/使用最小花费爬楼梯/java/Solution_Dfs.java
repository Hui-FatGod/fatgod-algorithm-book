class Solution_Dfs {
    private final static int NOT_CALC = -1;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memory = new int[n + 1];
        Arrays.fill(memory, NOT_CALC);
        return dfs(n, cost, memory);
    }

    private int dfs(int i, int[] cost, int[] memory) {
        if (i <= 1) {
            return 0;
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        return memory[i] = Math.min(cost[i - 1] + dfs(i - 1, cost, memory)
                , cost[i - 2] + dfs(i - 2, cost, memory));
    }
}