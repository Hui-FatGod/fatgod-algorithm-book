const NOT_CALC = -1

function rob(nums: number[]): number {
    const n = nums.length
    if (n === 1) {
        return nums[0]
    }
    return Math.max(sequenceRob(nums, 0, n - 2), sequenceRob(nums, 1, n - 1))
}

function sequenceRob(nums: number[], start: number, end: number): number {
    const memory: number[] = Array(end + 1).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i === start) {
            return nums[start]
        }
        if (i === start + 1) {
            return Math.max(nums[start], nums[start + 1])
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        return memory[i] = Math.max(nums[i] + dfs(i - 2), dfs(i - 1))
    }
    return dfs(end)
}

export { }