function maxFreq(s: string, maxLetters: number, minSize: number, maxSize: number): number {
    const k = minSize, length = s.length
    if (k > length) {
        return 0
    }
    const letterMap: Map<string, number> = new Map()
    const subStrMap: Map<string, number> = new Map()
    for (let i = 0; i < k; i++) {
        letterMap.set(s.charAt(i), (letterMap.get(s.charAt(i)) || 0) + 1)
    }
    let maxFreq = letterMap.size <= maxLetters ? 1 : 0
    subStrMap.set(s.substring(0, k), maxFreq)
    for (let i = k; i < length; i++) {
        letterMap.set(s.charAt(i), (letterMap.get(s.charAt(i)) || 0) + 1)
        const cnt = letterMap.get(s.charAt(i - k))!
        if (cnt <= 1) {
            letterMap.delete(s.charAt(i - k))
        } else {
            letterMap.set(s.charAt(i - k), cnt - 1)
        }
        if (letterMap.size > maxLetters) {
            continue
        }
        const subStr = s.substring(i - k + 1, i + 1)
        const subStrCnt = (subStrMap.get(subStr) || 0) + 1
        subStrMap.set(subStr, subStrCnt)
        maxFreq = Math.max(maxFreq, subStrCnt)
    }
    return maxFreq
}