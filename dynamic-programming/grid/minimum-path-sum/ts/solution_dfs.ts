const NOT_CALCULATE_VALUE = -1

function minPathSum(grid: number[][]): number {
    const m = grid.length, n = grid[0].length
    const memory: number[][] = Array.from({length: m}, (): number[] => Array(n).fill(NOT_CALCULATE_VALUE))
    const dfs = (i: number, j: number): number => {
        if (i < 0 || j < 0) {
            return Number.MAX_SAFE_INTEGER
        }
        if (i === 0 && j === 0) {
            return grid[0][0]
        }
        if (memory[i][j] !== NOT_CALCULATE_VALUE) {
            return memory[i][j]
        }
        return memory[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - 1)) + grid[i][j]
    }
    return dfs(m - 1, n - 1)
}

export { minPathSum }