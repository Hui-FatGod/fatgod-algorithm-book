function calculateMinimumHP(dungeon: number[][]): number {
    const m = dungeon.length, n = dungeon[0].length
    const dp: number[][] = Array.from({length: m + 1}, (): number[] => Array(n + 1))
    for (let i = m; i >= 0; i--) {
        for (let j = n; j >= 0; j--) {
            if (i == m || j == n) {
                dp[i][j] = Number.MAX_SAFE_INTEGER
                continue
            }
            if (i == m - 1 && j == n - 1) {
                dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1)
                continue
            }
            dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1)
        }
    }
    return dp[0][0]
}

export { calculateMinimumHP }