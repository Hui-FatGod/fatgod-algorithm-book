function shareCandies(candies: number[], k: number): number {
    const map: Map<number, number> = new Map()
    for (const candy of candies) {
        map.set(candy, (map.get(candy) || 0) + 1)
    }
    if (k === 0) {
        return map.size
    }
    for (let i = 0; i < k; i++) {
        const cnt = map.get(candies[i])!
        if (cnt <= 1) {
            map.delete(candies[i])
        } else {
            map.set(candies[i], cnt - 1)
        }
    }
    let maxType = map.size
    for (let i = k; i < candies.length; i++) {
        const cnt = map.get(candies[i])!
        if (cnt <= 1) {
            map.delete(candies[i])
        } else {
            map.set(candies[i], cnt - 1)
        }
        map.set(candies[i - k], (map.get(candies[i - k]) || 0) + 1)
        maxType = Math.max(maxType, map.size)
    }
    return maxType
}