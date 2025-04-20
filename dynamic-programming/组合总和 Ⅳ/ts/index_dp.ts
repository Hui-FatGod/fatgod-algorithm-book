function combinationSum4(nums: number[], target: number): number {
    const dp: number[] = Array(target + 1).fill(0)
    dp[0] = 1
    for (let i = 1; i < target + 1; i++) {
        for (let num of nums) {
            if (i < num) {
                continue
            }
            dp[i] += dp[i - num]
        }
    }
    return dp[target]
}

export {}