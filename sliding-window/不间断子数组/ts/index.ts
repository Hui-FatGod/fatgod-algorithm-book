function continuousSubarrays(nums: number[]): number {
    const countTable: Map<number, number> = new Map()
    let subs = 0
    for (let left = 0, right = 0; right < nums.length; right++) {
        countTable.set(nums[right], (countTable.get(nums[right]) || 0) + 1)
        while (true) {
            let max = 0, min = Number.MAX_SAFE_INTEGER
            for (let number of countTable.keys()) {
                max = Math.max(max, number)
                min = Math.min(min, number)
            }
            if (max - min <= 2) {
                break
            }
            const count = countTable.get(nums[left])!
            if (count <= 1) {
                countTable.delete(nums[left++])
                continue
            }
            countTable.set(nums[left++], count - 1)
        }
        subs += right - left + 1
    }
    return subs
}