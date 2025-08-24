function minimumTotal(triangle: number[][]): number {
    const n = triangle.length
    let start = 0
    const dp: number[][] = Array.from({length: n}, (): number[] => Array(++start))
    for (let i = n - 1; i >= 0; i--) {
        for (let j = 0; j < i + 1; j++) {
            if (i === n - 1) {
                dp[n - 1][j] = triangle[n - 1][j]
                continue
            }
            dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
        }
    }
    return dp[0][0]
}

export { minimumTotal }