function minFallingPathSum(matrix: number[][]): number {
    const n = matrix[0].length
    const current: number[] = Array(n + 2).fill(0)
    current[0] = current[n + 1] = Number.MAX_SAFE_INTEGER
    for (const row of matrix) {
        let prev: number = current[0]
        for (let j = 0; j < n; j++) {
            const temp = prev
            prev = current[j + 1]
            current[j + 1] = Math.min(temp, current[j + 1], current[j + 2]) + row[j]
        }
    }
    let minSum: number = Number.MAX_SAFE_INTEGER
    for (let i = 1; i < n + 1; i++) {
        minSum = Math.min(minSum, current[i])
    }
    return minSum
}

export { minFallingPathSum }