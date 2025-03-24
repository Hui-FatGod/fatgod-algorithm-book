function numberOfSpecialSubstrings(s: string): number {
    const countTable: number[] = Array(26).fill(0)
    let subs = 0
    for (let left = 0, right = 0; right < s.length; right++) {
        countTable[s.charCodeAt(right) - 97]++
        while (countTable[s.charCodeAt(right) - 97] > 1) {
            countTable[s.charCodeAt(left++) - 97]--
        }
        subs += right - left + 1
    }
    return subs
}