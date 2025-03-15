function countGood(nums: number[], k: number): number {
    const n = nums.length
    const countTable: Map<number, number> = new Map()
    let goodSubs = 0, pairs = 0
    for (let left = 0, right = 0; right < n; right++) {
        countTable.set(nums[right], (countTable.get(nums[right]) || 0) + 1)
        pairs += countTable.get(nums[right])! - 1
        while (pairs >= k) {
            goodSubs += n - right
            const count = countTable.get(nums[left])! - 1
            countTable.set(nums[left++], count)
            pairs -= count
        }
    }
    return goodSubs
}