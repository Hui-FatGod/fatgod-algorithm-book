const NOT_CALCULATED_VALUE = undefined

function minimumTotal(triangle: number[][]): number {
    const m = triangle.length
    const memory: number[][] = Array.from({length: m}, (): number[] => [])
    const dfs = (i: number, j: number): number => {
        if (i === m - 1) {
            return triangle[i][j]
        }
        if (memory[i][j] !== NOT_CALCULATED_VALUE) {
            return memory[i][j]
        }
        return memory[i][j] = Math.min(dfs(i + 1, j), dfs(i + 1, j + 1)) + triangle[i][j]
    }
    return dfs(0, 0)
}

export { minimumTotal }