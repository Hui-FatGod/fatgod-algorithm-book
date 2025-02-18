function maxSum(nums: number[], m: number, k: number): number {
    const map: Map<number, number> = new Map()
    let sum = 0
    for (let i = 0; i < k; i++) {
        sum += nums[i]
        map.set(nums[i], (map.get(nums[i]) || 0) + 1)
    }
    let maxSum = map.size >= m ? sum : 0
    for (let i = k; i < nums.length; i++) {
        sum += nums[i] - nums[i - k]
        map.set(nums[i], (map.get(nums[i]) || 0) + 1)
        const cnt = map.get(nums[i - k])!
        if (cnt <= 1) {
            map.delete(nums[i - k])
        } else {
            map.set(nums[i - k], cnt - 1)
        }
        maxSum = Math.max(maxSum, map.size >= m ? sum : 0)
    }
    return maxSum
}