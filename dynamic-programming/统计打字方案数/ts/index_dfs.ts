const NOT_CALC = -1, MOD = 1e9 + 7
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
    const dfs = (i: number, letters: number, memory: number[]): number => {
        if (i < 0) {
            return 0
        }
        if (i === 0) {
            return 1
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        let schemes = 0
        for (let j = 1; j < letters + 1; j++) {
            schemes = (schemes + dfs(i - j, letters, memory)) % MOD
        }
        return memory[i] = schemes
    }
    const memory3: number[] = Array(maxCount + 1).fill(NOT_CALC), memory4 = Array(maxCount + 1).fill(NOT_CALC)
    let texts = 1n
    for (let tuple of tuples) {
        texts = texts * BigInt(dfs(tuple[0], tuple[1], tuple[1] === 3 ? memory3 : memory4)) % BigInt(MOD)
    }
    return Number(texts)
}

export { }