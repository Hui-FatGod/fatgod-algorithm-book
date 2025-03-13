function numberOfSubstrings(s: string, k: number): number {
    const length = s.length
    const countTable = Array(26).fill(0)
    let subs = 0
    for (let left = 0, right = 0; right < length; right++) {
        countTable[s.charCodeAt(right) - 97]++
        while (countTable[s.charCodeAt(right) - 97] >= k) {
            subs += length - right
            countTable[s.charCodeAt(left++) - 97]--
        }
    }
    return subs
}