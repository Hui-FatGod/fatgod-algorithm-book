function countCompleteSubarrays(nums: number[]): number {
    const n = nums.length
    const set: Set<number> = new Set()
    nums.forEach(num => set.add(num))
    const countTable: Map<number, number> = new Map()
    let completeSubs = 0
    for (let left = 0, right = 0; right < n; right++) {
        countTable.set(nums[right], (countTable.get(nums[right]) || 0) + 1)
        while (countTable.size === set.size) {
            completeSubs += n - right
            const count = countTable.get(nums[left])!
            if (count <= 1) {
                countTable.delete(nums[left++])
            } else {
                countTable.set(nums[left++], count - 1)
            }
        }
    }
    return completeSubs
}