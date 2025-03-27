function ascii(str: string): number {
    return str.charCodeAt(0)
}

const Q = ascii('Q'), W = ascii('W'), E = ascii('E'), R = ascii('R')

function balancedString(s: string): number {
    const countTable: number[] = Array(W - E + 1).fill(0)
    for (let i = 0; i < s.length; i++) {
        countTable[s.charCodeAt(i) - E]++
    }
    const length = s.length, m = length / 4
    if (countTable[Q - E] === m && countTable[W - E] === m
        && countTable[0] === m && countTable[R - E] === m) {
        return 0
    }
    let minLength = length + 1
    for (let left = 0, right = 0; right < length; right++) {
        countTable[s.charCodeAt(right) - E]--
        while (countTable[Q - E] <= m && countTable[W - E] <= m
            && countTable[0] <= m && countTable[R - E] <= m) {
            minLength = Math.min(minLength, right - left + 1)
            countTable[s.charCodeAt(left++) - E]++
        }
    }
    return minLength
}