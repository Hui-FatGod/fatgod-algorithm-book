function minCostClimbingStairs(cost: number[]): number {
    const n = cost.length
    if (n == 1) {
        return cost[0]
    }
    if (n == 2) {
        return Math.min(cost[0], cost[1])
    }
    const dp: number[] = []
    dp[0] = 0
    dp[1] = 0
    for (let i = 2; i < n + 1; i++) {
        dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2])
    }
    return dp[n]
}

export {}