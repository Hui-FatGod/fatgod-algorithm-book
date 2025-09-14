const VISITED_VALUE = -1
const DIRS: number[][] = [[-1, 0], [0, 1], [1, 0], [0, -1]]

function countIslands(grid: number[][], k: number): number {
    const m = grid.length, n = grid[0].length
    const dfs = (row: number, col: number): number => {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] <= 0) {
            return 0
        }
        let total: number = grid[row][col]
        grid[row][col] = VISITED_VALUE
        for (const dir of DIRS) {
            total += dfs(row + dir[0], col + dir[1])
        }
        return total
    }
    let count: number = 0
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] > 0 && dfs(i, j) % k === 0) {
                count++
            }
        }
    }
    return count
}

export { countIslands }