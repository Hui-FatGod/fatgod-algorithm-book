const MOD = 1e9 + 7

function countHousePlacements(n: number): number {
    if (n === 1) {
        return 2 * 2
    }
    if (n === 2) {
        return 3 * 3
    }
    const dp: number[] = []
    dp[1] = 2
    dp[2] = 3
    for (let i = 3; i < n + 1; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % MOD
    }
    const count = BigInt(dp[n])
    return Number(count * count % BigInt(MOD))
}

export { }