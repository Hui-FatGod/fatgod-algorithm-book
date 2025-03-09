function takeCharacters(s: string, k: number): number {
    const length = s.length
    if (length < 3 * k) {
        return -1
    }
    const countTable: [number, number, number] = [0, 0, 0]
    for (let i = 0; i < length; i++) {
        countTable[s.charCodeAt(i) - 97]++
    }
    if (countTable[0] < k || countTable[1] < k || countTable[2] < k) {
        return -1
    }
    let maxLength = 0
    for (let left = 0, right = 0; right < length; right++) {
        countTable[s.charCodeAt(right) - 97]--
        while (countTable[s.charCodeAt(right) - 97] < k) {
            countTable[s.charCodeAt(left++) - 97]++
        }
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return length - maxLength
}