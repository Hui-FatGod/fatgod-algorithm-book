const NOT_CALC = -1, MOD = 1e9 + 7

function countHousePlacements(n: number): number {
    const memory: number[] = Array(n + 1).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i === 1) {
            return 2
        }
        if (i === 2) {
            return 3
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        return memory[i] = (dfs(i - 1) + dfs(i - 2)) % MOD
    }
    const count = BigInt(dfs(n))
    return Number(count * count % BigInt(MOD))
}

export { }