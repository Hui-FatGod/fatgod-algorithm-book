class Solution_StateCompressionDp {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int prev = 0, current = 0;
        for (int i = 2; i < n + 1; i++) {
            int next = Math.min(cost[i - 1] + current, cost[i - 2] + prev);
            prev = current;
            current = next;
        }
        return current;
    }
}