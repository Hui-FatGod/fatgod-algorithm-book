function minimumTotal(triangle: number[][]): number {
    const n = triangle.length
    const current: number[] = Array(n + 1).fill(0)
    for (let i = n - 1; i >= 0; i--) {
        for (let j = 0; j < i + 1; j++) {
            current[j] = Math.min(current[j], current[j + 1]) + triangle[i][j]
        }
    }
    return current[0]
}

export { minimumTotal }