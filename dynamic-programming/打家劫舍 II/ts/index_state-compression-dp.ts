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
    let prev = nums[start], current = nums[start + 1]
    for (let i = start + 2; i < end + 1; i++) {
        const next = Math.max(nums[i] + prev, current)
        prev = current
        current = next
    }
    return current
}

export { }