function mostPoints(questions: number[][]): number {
    const n = questions.length
    const dp: number[] = []
    dp[n - 1] = questions[n - 1][0]
    for (let i = n - 2; i >= 0; i--) {
        dp[i] = Math.max(questions[i][0] + (dp[i + questions[i][1] + 1] || 0), dp[i + 1])
    }
    return dp[0]
}

export {}