const NOT_CALC = -1, MOD = 1e9 + 7

function countGoodStrings(low: number, high: number, zero: number, one: number): number {
    const memory: number[] = Array(high + 1).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i < 0) {
            return 0
        }
        if (i === 0) {
            return 1
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        return memory[i] = (dfs(i - zero) + dfs(i - one)) % MOD
    }
    let goodStrCount = 0
    for (let i = low; i < high + 1; i++) {
        goodStrCount = (goodStrCount + dfs(i)) % MOD
    }
    return goodStrCount
}

export {}