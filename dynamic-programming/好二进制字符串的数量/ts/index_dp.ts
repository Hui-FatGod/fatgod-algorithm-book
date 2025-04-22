const MOD = 1e9 + 7

function goodBinaryStrings(minLength: number, maxLength: number, oneGroup: number, zeroGroup: number): number {
    const dp: number[] = []
    dp[0] = 1
    let goodBinaryStrCount = 0
    for (let i = 1; i < maxLength + 1; i++) {
        dp[i] = ((i >= oneGroup ? dp[i - oneGroup] : 0) + (i >= zeroGroup ? dp[i - zeroGroup] : 0)) % MOD
        goodBinaryStrCount = (goodBinaryStrCount + (i >= minLength ? dp[i] : 0)) % MOD
    }
    return goodBinaryStrCount
}

export {}