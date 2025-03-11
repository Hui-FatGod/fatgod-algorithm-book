function numberOfSubstrings(s: string): number {
    const length = s.length
    const countTable: [number, number, number] = [0, 0, 0]
    let subs = 0
    for (let left = 0, right = 0; right < length; right++) {
        countTable[s.charCodeAt(right) - 97]++
        while (countTable[0] > 0 && countTable[1] > 0 && countTable[2] > 0) {
            subs += length - right
            countTable[s.charCodeAt(left++) - 97]--
        }
    }
    return subs
}