const NOT_CALC = -1

function combinationSum4(nums: number[], target: number): number {
    const memory: number[] = Array(target + 1).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i === 0) {
            return 1
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        let combinations = 0
        for (let num of nums) {
            if (num > i) {
                continue
            }
            combinations += dfs(i - num)
        }
        return memory[i] = combinations
    }
    return dfs(target)
}