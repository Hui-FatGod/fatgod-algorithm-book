const MOD = 1e9 + 7
const KEY_LETTERS = [0, 0, 3, 3, 3, 3, 3, 4, 3, 4]

function countTexts(pressedKeys: string): number {
    const tuples: number[][] = []
    let count = 0, maxCount = 0
    for (let i = 0; i < pressedKeys.length; i++) {
        count++
        if (i === pressedKeys.length - 1 || pressedKeys.charAt(i) !== pressedKeys.charAt(i + 1)) {
            tuples.push([count, KEY_LETTERS[pressedKeys.charCodeAt(i) - 48]])
            maxCount = Math.max(maxCount, count)
            count = 0
        }
    }
    const getDp = (letters: number, dp: number[]): number[] => {
        if (dp[0] === 1) {
            return dp
        }
        dp[0] = 1
        for (let i = 1; i < maxCount + 1; i++) {
            for (let j = 1; j < letters + 1; j++) {
                if (i < j) {
                    continue
                }
                dp[i] = ((dp[i] || 0) + dp[i - j]) % MOD
            }
        }
        return dp
    }
    const dp3: number[] = [], dp4: number[] = []
    let texts = 1n
    for (let tuple of tuples) {
        texts = texts * BigInt((tuple[1] === 3 ? getDp(3, dp3) : getDp(4, dp4))[tuple[0]]) % BigInt(MOD)
    }
    return Number(texts)
}

export { }