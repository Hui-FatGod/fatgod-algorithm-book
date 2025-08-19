function minFallingPathSum(matrix: number[][]): number {
    const m = matrix.length, n = matrix[0].length
    const dp: number[][] = Array.from({length: m}, (): number[] => Array(n + 2))
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n + 2; j++) {
            if (j === 0 || j === n + 1) {
                dp[i][j] = Number.MAX_SAFE_INTEGER
                continue
            }
            if (i === 0) {
                dp[0][j] = matrix[0][j - 1]
                continue
            }
            dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j - 1]
        }
    }
    let minSum: number = Number.MAX_SAFE_INTEGER
    for (let i = 1; i < n + 1; i++) {
        minSum = Math.min(minSum, dp[m - 1][i])
    }
    return minSum
}

export { minFallingPathSum }