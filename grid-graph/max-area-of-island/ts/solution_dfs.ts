const LAND_VALUE = 1, VISITED = 2
const DIRS: number[][] = [[-1, 0], [0, 1], [1, 0], [0, -1]]

function maxAreaOfIsland(grid: number[][]): number {
    const m = grid.length, n = grid[0].length
    const dfs = (row: number, col: number): number => {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] !== LAND_VALUE) {
            return 0
        }
        grid[row][col] = VISITED
        let area: number = 1
        for (const dir of DIRS) {
            area += dfs(row + dir[0], col + dir[1])
        }
        return area
    }
    let maxArea: number = 0
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === LAND_VALUE) {
                maxArea = Math.max(maxArea, dfs(i, j))
            }
        }
    }
    return maxArea
}

export { maxAreaOfIsland }