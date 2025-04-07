function findAnagrams(s: string, p: string): number[] {
    const anagrams: number[] = []
    if (p.length > s.length) {
        return anagrams
    }
    const countTable: number[] = Array(26).fill(0)
    for (let i = 0; i < p.length; i++) {
        countTable[p.charCodeAt(i) - 97]++
    }
    let k = p.length, letters = 0
    for (let i = 0; i < k; i++) {
        letters += --countTable[s.charCodeAt(i) - 97] >= 0 ? 1 : 0
    }
    if (letters === k) {
        anagrams.push(0)
    }
    for (let i = k; i < s.length; i++) {
        letters += (--countTable[s.charCodeAt(i) - 97] >= 0 ? 1 : 0)
            - (++countTable[s.charCodeAt(i - k) - 97] >= 1 ? 1 : 0)
        if (letters === k) {
            anagrams.push(i - k + 1)
        }
    }
    return anagrams
}