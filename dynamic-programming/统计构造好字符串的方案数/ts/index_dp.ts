const MOD = 1e9 + 7

function countGoodStrings(low: number, high: number, zero: number, one: number): number {
    const dp: number[] = []
    dp[0] = 1
    let goodStrCount = 0
    for (let i = 1; i < high + 1; i++) {
        dp[i] = ((i >= zero ? dp[i - zero] : 0) + (i >= one ? dp[i - one] : 0)) % MOD
        goodStrCount = (goodStrCount + (i >= low ? dp[i] : 0)) % MOD
    }
    return goodStrCount
}

export {}