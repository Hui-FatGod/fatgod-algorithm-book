const NOT_CALC = -1

function rob(nums: number[]): number {
    const n = nums.length
    const memory: number[] = Array(n).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i === 0) {
            return nums[0]
        }
        if (i === 1) {
            return Math.max(nums[0], nums[1])
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        return memory[i] = Math.max(nums[i] + dfs(i - 2), dfs(i - 1))
    }
    return dfs(n - 1)
}

export { }