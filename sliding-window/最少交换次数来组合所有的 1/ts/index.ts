function minSwaps(data: number[]): number {
    let k = 0
    for (const item of data) {
        k += item
    }
    const n = data.length
    if (k <= 1 || k === n) {
        return 0
    }
    let swaps = 0
    for (let i = 0; i < k; i++) {
        swaps += data[i] ^ 1
    }
    let minSwaps = swaps
    for (let i = k; i < n; i++) {
        swaps += (data[i] ^ 1) - (data[i - k] ^ 1)
        minSwaps = Math.min(minSwaps, swaps)
    }
    return minSwaps
}