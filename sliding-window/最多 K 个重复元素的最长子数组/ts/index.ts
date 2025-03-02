function maxSubarrayLength(nums: number[], k: number): number {
    const map: Map<number, number> = new Map()
    let maxLength = 0
    for (let left = 0, right = 0; right < nums.length; right++) {
        map.set(nums[right], (map.get(nums[right]) || 0) + 1)
        while (map.get(nums[right])! > k) {
            const cnt = map.get(nums[left])!
            map.set(nums[left++], cnt - 1)
        }
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return maxLength
}