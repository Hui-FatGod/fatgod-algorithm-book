const NOT_CALCULATED_VALUE = undefined

function minFallingPathSum(matrix: number[][]): number {
    const m = matrix.length, n = matrix[0].length
    const memory: number[][] = Array.from({length: m}, (): number[] => Array(n).fill(NOT_CALCULATED_VALUE))
    const dfs = (i: number, j: number): number => {
        if (j < 0 || j >= n) {
            return Number.MAX_SAFE_INTEGER
        }
        if (i === 0) {
            return matrix[0][j]
        }
        if (memory[i][j] !== NOT_CALCULATED_VALUE) {
            return memory[i][j]
        }
        return memory[i][j] = Math.min(dfs(i - 1, j - 1), dfs(i - 1, j), dfs(i - 1, j + 1)) + matrix[i][j]
    }
    let minSum: number = Number.MAX_SAFE_INTEGER
    for (let i = 0; i < n; i++) {
        minSum = Math.min(minSum, dfs(m - 1, i))
    }
    return minSum
}

export { minFallingPathSum }