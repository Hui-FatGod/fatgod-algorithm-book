function deleteAndEarn(nums: number[]): number {
    const countTable: Map<number, number> = new Map()
    for (let num of nums) {
        countTable.set(num, (countTable.get(num) || 0) + 1)
    }
    const newNums: number[] = []
    let start = 0
    for (let num of countTable.keys()) {
        newNums[start++] = num
    }
    newNums.sort((a, b) => a - b)
    const n = newNums.length
    if (n === 1) {
        return newNums[0] * countTable.get(newNums[0])!
    }
    const dp: number[] = []
    dp[0] = newNums[0] * countTable.get(newNums[0])!
    for (let i = 1; i < n; i++) {
        const points = newNums[i] * countTable.get(newNums[i])!
        dp[i] = newNums[i] - newNums[i - 1] > 1 ? points + dp[i - 1]
            : Math.max(points + (dp[i - 2] || 0), dp[i - 1])
    }
    return dp[n - 1]
}

export {}