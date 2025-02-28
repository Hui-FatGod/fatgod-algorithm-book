function totalFruit(fruits: number[]): number {
    const map: Map<number, number> = new Map()
    let maxFruits = 0
    for (let left = 0, right = 0; right < fruits.length; right++) {
        map.set(fruits[right], (map.get(fruits[right]) || 0) + 1)
        while (map.size > 2) {
            const cnt = map.get(fruits[left])!
            if (cnt <= 1) {
                map.delete(fruits[left++])
            } else {
                map.set(fruits[left++], cnt - 1)
            }
        }
        maxFruits = Math.max(maxFruits, right - left + 1)
    }
    return maxFruits
}