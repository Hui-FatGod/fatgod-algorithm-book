const MOD = 1e9 + 7

function countHousePlacements(n: number): number {
    if (n === 1) {
        return 2 * 2
    }
    if (n === 2) {
        return 3 * 3
    }
    let prev = 2, current = 3
    for (let i = 3; i < n + 1; i++) {
        const next = (prev + current) % MOD
        prev = current
        current = next
    }
    const count = BigInt(current)
    return Number(count * count % BigInt(MOD))
}

export { }