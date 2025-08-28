const LAND_VALUE = '1', VISITED = '2'
const DIRS: number[][] = [[-1, 0], [0, 1], [1, 0], [0, -1]]

function numIslands(grid: string[][]): number {
    const m = grid.length, n = grid[0].length
    const dfs = (i: number, j: number): void => {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] !== LAND_VALUE) {
            return
        }
        grid[i][j] = VISITED
        for (const dir of DIRS) {
            dfs(i + dir[0], j + dir[1])
        }
    }
    let islandCount = 0
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === LAND_VALUE) {
                islandCount++
                dfs(i, j)
            }
        }
    }
    return islandCount
}

export { numIslands }