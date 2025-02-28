function maximumUniqueSubarray(nums: number[]): number {
    const set: Set<number> = new Set()
    let sum = 0, maxSum = sum
    for (let left = 0, right = 0; right < nums.length; right++) {
        while (set.has(nums[right])) {
            sum -= nums[left]
            set.delete(nums[left++])
        }
        sum += nums[right]
        set.add(nums[right])
        maxSum = Math.max(maxSum, sum)
    }
    return maxSum
}