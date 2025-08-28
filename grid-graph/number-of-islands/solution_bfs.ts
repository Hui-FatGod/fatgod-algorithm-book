const LAND_VALUE = '1', VISITED = '2'
const DIRS: number[][] = [[-1, 0], [0, 1], [1, 0], [0, -1]]

function numIslands(grid: string[][]): number {
    const m = grid.length, n = grid[0].length
    const queue: number[][] = []
    const bfs = (sourceRow: number, sourceCol: number): void => {
        grid[sourceRow][sourceCol] = VISITED
        queue.push([sourceRow, sourceCol])
        while (queue.length > 0) {
            const point: number[] = queue.shift()!
            const row = point[0], col = point[1]
            for (const dir of DIRS) {
                const nextRow = row + dir[0], nextCol = col + dir[1]
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n
                    || grid[nextRow][nextCol] !== LAND_VALUE) {
                    continue
                }
                grid[nextRow][nextCol] = VISITED
                queue.push([nextRow, nextCol])
            }
        }
    }
    let islandCount = 0
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === LAND_VALUE) {
                islandCount++
                bfs(i, j)
            }
        }
    }
    return islandCount
}

export { numIslands }