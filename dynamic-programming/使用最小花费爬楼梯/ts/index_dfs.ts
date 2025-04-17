const NOT_CALC = -1

function minCostClimbingStairs(cost: number[]): number {
    const n = cost.length
    const memory: number[] = Array(n + 1).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i <= 1) {
            return 0
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        return memory[i] = Math.min(cost[i - 1] + dfs(i - 1), cost[i - 2] + dfs(i - 2))
    }
    return dfs(n)
}

export {}