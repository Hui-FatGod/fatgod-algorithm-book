const NOT_CALC = -1, MOD = 1e9 + 7

function goodBinaryStrings(minLength: number, maxLength: number, oneGroup: number, zeroGroup: number): number {
    const memory: number[] = Array(maxLength + 1).fill(NOT_CALC)
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
        return memory[i] = (dfs(i - oneGroup) + dfs(i - zeroGroup)) % MOD
    }
    let goodBinaryStrCount = 0
    for (let i = minLength; i < maxLength + 1; i++) {
        goodBinaryStrCount = (goodBinaryStrCount + dfs(i)) % MOD
    }
    return goodBinaryStrCount
}

export {}