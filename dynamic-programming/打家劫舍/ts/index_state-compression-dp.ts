function rob(nums: number[]): number {
    const n = nums.length
    if (n === 1) {
        return nums[0]
    }
    if (n === 2) {
        return Math.max(nums[0], nums[1])
    }
    let prev = nums[0], current = Math.max(nums[0], nums[1])
    for (let i = 2; i < n; i++) {
        const next = Math.max(nums[i] + prev, current)
        prev = current
        current = next
    }
    return current
}

export { }