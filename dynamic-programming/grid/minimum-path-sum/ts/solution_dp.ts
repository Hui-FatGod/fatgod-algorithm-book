function minPathSum(grid: number[][]): number {
    const m = grid.length, n = grid[0].length
    const dp: number[][] = Array.from({length: m + 1}, (): number[] => Array(n + 1))
    for (let i = 0; i <= m; i++) {
        for (let j = 0; j <= n; j++) {
            if (i === 0 || j === 0) {
                dp[i][j] = Number.MAX_SAFE_INTEGER
                continue
            }
            if (i === 1 && j === 1) {
                dp[1][1] = grid[0][0]
                continue
            }
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1]
        }
    }
    return dp[m][n]
}

export { minPathSum }