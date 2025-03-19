function countKConstraintSubstrings(s: string, k: number): number {
    const countTable: [number, number] = [0, 0]
    let subs = 0
    for (let left = 0, right = 0; right < s.length; right++) {
        countTable[s.charCodeAt(right) - 48]++
        while (countTable[0] > k && countTable[1] > k) {
            countTable[s.charCodeAt(left++) - 48]--
        }
        subs += right - left + 1
    }
    return subs
}