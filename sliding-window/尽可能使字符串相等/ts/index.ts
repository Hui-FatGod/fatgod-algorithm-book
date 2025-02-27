function equalSubstring(s: string, t: string, maxCost: number): number {
    const length = s.length
    const costs: number[] = Array(length)
    let totalCost = 0, maxLength = 0
    for (let right = 0, left = 0; right < length; right++) {
        const cost = costs[right] = Math.abs(s.charCodeAt(right) - t.charCodeAt(right))
        while (maxCost - totalCost < cost) {
            totalCost -= costs[left++]
        }
        totalCost += cost
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return maxLength
}