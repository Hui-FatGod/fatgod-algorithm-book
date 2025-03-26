function shortestBeautifulSubstring(s: string, k: number): string {
    const length = s.length
    let minLength = length + 1, oneCount = 0
    let minSub = ''
    for (let left = 0, right = 0; right < length; right++) {
        oneCount += s.charCodeAt(right) - 48
        while (oneCount === k) {
            const currentLength = right - left + 1
            const currentSub = s.substring(left, right + 1)
            oneCount -= s.charCodeAt(left++) - 48
            if (currentLength > minLength) {
                continue
            }
            if (currentLength < minLength) {
                minLength = currentLength
                minSub = currentSub
                continue
            }
            minSub = currentSub < minSub ? currentSub : minSub
        }
    }
    return minSub
}