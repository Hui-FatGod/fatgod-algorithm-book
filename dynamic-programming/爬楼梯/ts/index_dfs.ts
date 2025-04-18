const NOT_CALC = -1

function climbStairs(n: number): number {
    const memory: number[] = Array(n + 1).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i <= 2) {
            return i
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        return memory[i] = dfs(i - 1) + dfs(i - 2)
    }
    return dfs(n)
}

export {}