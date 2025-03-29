const z = 'z'.charCodeAt(0), A = 'A'.charCodeAt(0)

function minWindow(s: string, t: string): string {
    const length = s.length
    const countTable: number[] = Array(z - A + 1).fill(0)
    let eligibleChars = 0
    for (let i = 0; i < t.length; i++) {
        eligibleChars += ++countTable[t.charCodeAt(i) - A] === 1 ? 1 : 0
    }
    let minSubLeft = 0, minSubRight = length
    for (let left = 0, right = 0; right < length; right++) {
        eligibleChars -= --countTable[s.charCodeAt(right) - A] === 0 ? 1 : 0
        while (eligibleChars === 0) {
            if (right - left < minSubRight - minSubLeft) {
                minSubLeft = left
                minSubRight = right
            }
            eligibleChars += ++countTable[s.charCodeAt(left++) - A] > 0 ? 1 : 0
        }
    }
    return minSubRight >= length ? "" : s.substring(minSubLeft, minSubRight + 1)
}