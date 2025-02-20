function minimumDifference(nums: number[], k: number): number {
    nums.sort((n1, n2) => n1 - n2)
    let minDiff = nums[k - 1] - nums[0]
    for (let i = k; i < nums.length; i++) {
        minDiff = Math.min(minDiff, nums[i] - nums[i - k + 1])
    }
    return minDiff
}