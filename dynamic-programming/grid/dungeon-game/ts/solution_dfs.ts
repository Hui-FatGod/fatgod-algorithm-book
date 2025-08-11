const NOT_CALCULATE_VALUE = -1

function calculateMinimumHP(dungeon: number[][]): number {
    const m = dungeon.length, n = dungeon[0].length
    const memory: number[][] = Array.from({length: m}, (): number[] => Array(n).fill(NOT_CALCULATE_VALUE))
    const dfs = (i: number, j: number): number => {
        if (i >= m || j >= n) {
            return Number.MAX_SAFE_INTEGER
        }
        if (i === m - 1 && j === n - 1) {
            return Math.max(1 - dungeon[m - 1][n - 1], 1)
        }
        if (memory[i][j] !== NOT_CALCULATE_VALUE) {
            return memory[i][j]
        }
        return memory[i][j] = Math.max(Math.min(dfs(i + 1, j), dfs(i, j + 1)) - dungeon[i][j], 1)
    }
    return dfs(0, 0)
}

export { calculateMinimumHP }