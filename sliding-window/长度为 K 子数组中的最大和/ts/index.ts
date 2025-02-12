function maximumSubarraySum(nums: number[], k: number): number {
    let sum = 0
    const map: Map<number, number> = new Map()
    for (let i = 0; i < k; i++) {
        sum += nums[i]
        map.set(nums[i], (map.get(nums[i]) || 0) + 1)
    }
    let maxSum = map.size < k ? 0 : sum
    for (let i = k; i < nums.length; i++) {
        sum += nums[i] - nums[i - k]
        const cnt = map.get(nums[i - k])!
        if (cnt <= 1) {
            map.delete(nums[i - k])
        } else {
            map.set(nums[i - k], cnt - 1)
        }
        map.set(nums[i], (map.get(nums[i]) || 0) + 1)
        maxSum = Math.max(maxSum, map.size < k ? 0 : sum)
    }
    return maxSum
}