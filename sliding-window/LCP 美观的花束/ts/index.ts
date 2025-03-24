function beautifulBouquet(flowers: number[], cnt: number): number {
    const countTable: Map<number, number> = new Map()
    let subs = 0
    for (let left = 0, right = 0; right < flowers.length; right++) {
        countTable.set(flowers[right], (countTable.get(flowers[right]) || 0) + 1)
        while (countTable.get(flowers[right])! > cnt) {
            countTable.set(flowers[left], countTable.get(flowers[left++])! - 1)
        }
        subs += right - left + 1
    }
    return subs % (1e9 + 7)
}