function minPathSum(grid: number[][]): number {
    const n = grid[0].length
    const current: number[] = Array(n + 1).fill(Number.MAX_SAFE_INTEGER)
    current[1] = 0
    for (let row of grid) {
        for (let i = 1; i <= n; i++) {
            current[i] = Math.min(current[i - 1], current[i]) + row[i - 1]
        }
    }
    return current[n]
}

export { minPathSum }