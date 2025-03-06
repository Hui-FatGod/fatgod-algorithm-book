function longestSemiRepetitiveSubstring(s: string): number {
    let maxLength = 1, same = 0
    for (let left = 0, right = 1; right < s.length; right++) {
        same += s.charCodeAt(right) === s.charCodeAt(right - 1) ? 1 : 0
        while (same > 1) {
            same -= s.charCodeAt(left) === s.charCodeAt(left++ + 1) ? 1 : 0
        }
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return maxLength
}