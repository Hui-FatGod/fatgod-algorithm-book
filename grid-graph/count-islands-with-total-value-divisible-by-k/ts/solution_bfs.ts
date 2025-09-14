const VISITED_VALUE = -1
const DIRS: number[][] = [[-1, 0], [0, 1], [1, 0], [0, -1]]

function countIslands(grid: number[][], k: number): number {
    const m = grid.length, n = grid[0].length
    const queue: number[][] = []
    const bfs = (sourceRow: number, sourceCol: number): number => {
        let total: number = grid[sourceRow][sourceCol]
        queue.push([sourceRow, sourceCol])
        grid[sourceRow][sourceCol] = VISITED_VALUE
        while (queue.length > 0) {
            const point: number[] = queue.shift()!
            const row = point[0], col = point[1]
            for (const dir of DIRS) {
                const nextRow = row + dir[0], nextCol = col + dir[1]
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] <= 0) {
                    continue
                }
                total += grid[nextRow][nextCol]
                queue.push([nextRow, nextCol])
                grid[nextRow][nextCol] = VISITED_VALUE
            }
        }
        return total
    }
    let count: number = 0
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] > 0 && bfs(i, j) % k === 0) {
                count++
            }
        }
    }
    return count
}

export { countIslands }