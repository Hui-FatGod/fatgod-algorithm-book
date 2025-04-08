function checkInclusion(s1: string, s2: string): boolean {
    if (s1.length > s2.length) {
        return false
    }
    const countTable: number[] = Array(26).fill(0)
    for (let i = 0; i < s1.length; i++) {
        countTable[s1.charCodeAt(i) - 97]++
    }
    const k = s1.length
    let letters = 0
    for (let i = 0; i < k; i++) {
        letters += --countTable[s2.charCodeAt(i) - 97] >= 0 ? 1 : 0
    }
    if (letters === k) {
        return true
    }
    for (let i = k; i < s2.length; i++) {
        letters += (--countTable[s2.charCodeAt(i) - 97] >= 0 ? 1 : 0)
            - (++countTable[s2.charCodeAt(i - k) - 97] >= 1 ? 1 : 0)
        if (letters === k) {
            return true
        }
    }
    return false
}