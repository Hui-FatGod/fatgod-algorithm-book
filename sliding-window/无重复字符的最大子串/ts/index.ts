function lengthOfLongestSubstring(s: string): number {
    const set: Set<string> = new Set()
    let maxLength = 0
    for (let right = 0, left = 0; right < s.length; right++) {
        while (set.has(s.charAt(right))) {
            set.delete(s.charAt(left++))
        }
        set.add(s.charAt(right))
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return maxLength
}