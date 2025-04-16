const NOT_VISITED = -1

function climbStairs(n: number): number {
    const memory: number[] = Array(n + 1).fill(NOT_VISITED)
    const dfs = (i: number): number => {
        if (i <= 2) {
            return i
        }
        if (memory[i] !== NOT_VISITED) {
            return memory[i]
        }
        return memory[i] = dfs(i - 1) + dfs(i - 2)
    }
    return dfs(n)
}

export {}