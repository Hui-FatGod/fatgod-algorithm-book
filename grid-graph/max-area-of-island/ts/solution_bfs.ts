const LAND_VALUE = 1, VISITED = 2
const DIRS: number[][] = [[-1, 0], [0, 1], [1, 0], [0, -1]]

function maxAreaOfIsland(grid: number[][]): number {
    const m = grid.length, n = grid[0].length
    const queue: number[][] = []
    const bfs = (sourceRow: number, sourceCol: number): number => {
        grid[sourceRow][sourceCol] = VISITED
        queue.push([sourceRow, sourceCol])
        let area: number = 1
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
                area++
            }
        }
        return area
    }
    let maxArea: number = 0
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === LAND_VALUE) {
                maxArea = Math.max(maxArea, bfs(i, j))
            }
        }
    }
    return maxArea
}

export { maxAreaOfIsland }