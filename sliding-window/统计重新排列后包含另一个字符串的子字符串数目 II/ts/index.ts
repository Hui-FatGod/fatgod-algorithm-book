function validSubstringCount(word1: string, word2: string): number {
    const word1Length = word1.length, word2Length = word2.length
    if (word1Length < word2Length) {
        return 0
    }
    const countTable: number[] = Array(26).fill(0)
    for (let i = 0; i < word2Length; i++) {
        countTable[word2.charCodeAt(i) - 97]++
    }
    let subs = 0, letters = 0
    for (let left = 0, right = 0; right < word1Length; right++) {
        countTable[word1.charCodeAt(right) - 97]--
        if (countTable[word1.charCodeAt(right) - 97] < 0) {
            continue
        }
        letters++
        while (letters === word2Length) {
            subs += word1Length - right
            if (countTable[word1.charCodeAt(left) - 97] >= 0) {
                letters--
            }
            countTable[word1.charCodeAt(left++) - 97]++
        }
    }
    return subs
}