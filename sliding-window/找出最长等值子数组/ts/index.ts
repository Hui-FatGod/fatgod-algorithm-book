function longestEqualSubarray(nums: number[], k: number): number {
    const countTable: Map<number, number> = new Map()
    let maxFreq = 0
    for (let left = 0, right = 0; right < nums.length; right++) {
        countTable.set(nums[right], (countTable.get(nums[right]) || 0) + 1)
        maxFreq = Math.max(maxFreq, countTable.get(nums[right])!)
        while (right - left + 1 - maxFreq > k) {
            countTable.set(nums[left], countTable.get(nums[left++])! - 1)
        }
    }
    return maxFreq
}