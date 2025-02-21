function hasAllCodes(s: string, k: number): boolean {
    const length = s.length
    if (length - k + 1 < (1 << k)) {
        return false
    }
    const set: Set<number> = new Set()
    let value = 0
    for (let i = 0; i < k; i++) {
        value += (s.charCodeAt(i) - 48) << (k - i - 1)
    }
    set.add(value)
    for (let i = k; i < length; i++) {
        value -= (s.charCodeAt(i - k) - 48) << (k - 1)
        value <<= 1
        value += s.charCodeAt(i) - 48
        set.add(value)
    }
    return set.size === 1 << k
}