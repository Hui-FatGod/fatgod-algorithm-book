function maximumLengthSubstring(s: string): number {
    const cntMap: number[] = Array(26).fill(0)
    let maxLength = 0
    for (let left = 0, right = 0; right < s.length; right++) {
        while (cntMap[s.charCodeAt(right) - 97] > 1) {
            cntMap[s.charCodeAt(left++) - 97]--
        }
        cntMap[s.charCodeAt(right) - 97]++
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return maxLength
}