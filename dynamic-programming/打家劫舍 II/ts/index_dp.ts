function rob(nums: number[]): number {
    const n = nums.length
    if (n === 1) {
        return nums[0]
    }
    return Math.max(sequenceRob(nums, 0, n - 2), sequenceRob(nums, 1, n - 1))
}

function sequenceRob(nums: number[], start: number, end: number): number {
    const n = end - start + 1
    if (n === 1) {
        return nums[start]
    }
    if (n === 2) {
        return Math.max(nums[start], nums[start + 1])
    }
    const dp: number[] = []
    dp[start] = nums[start]
    dp[start + 1] = Math.max(nums[start], nums[start + 1])
    for (let i = start + 2; i < end + 1; i++) {
        dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1])
    }
    return dp[end]
}

export { }