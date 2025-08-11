function calculateMinimumHP(dungeon: number[][]): number {
    const m = dungeon.length, n = dungeon[0].length
    const current: number[] = Array(n + 1).fill(Number.MAX_SAFE_INTEGER)
    current[n - 1] = 1
    for (let i = m - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            current[j] = Math.max(Math.min(current[j], current[j + 1]) - dungeon[i][j], 1)
        }
    }
    return current[0]
}

export { calculateMinimumHP }