function minFlips(s: string): number {
    const length = s.length
    let notEqualCount = 0
    for (let i = 0; i < length; i++) {
        notEqualCount += (s.charCodeAt(i) ^ i) & 1
    }
    let minFlips = Math.min(notEqualCount, length - notEqualCount)
    for (let i = length; i < 2 * length - 1; i++) {
        notEqualCount += ((s.charCodeAt(i % length) ^ i) & 1) -
            ((s.charCodeAt((i - length) % length) ^ (i - length)) & 1)
        minFlips = Math.min(minFlips, Math.min(notEqualCount, length - notEqualCount))
    }
    return minFlips
}