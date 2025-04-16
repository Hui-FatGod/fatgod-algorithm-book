function climbStairs(n: number): number {
    if (n <= 2) {
        return n
    }
    let prev = 1, current = 2
    for (let i = 3; i < n + 1; i++) {
        const next = prev + current
        prev = current
        current = next
    }
    return current
}

export {}