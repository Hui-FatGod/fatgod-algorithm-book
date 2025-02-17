function minSwaps(data: number[]): number {
    let k = 0
    for (const item of data) {
        k += item
    }
    const n = data.length
    if (k <= 1 || k === n) {
        return 0
    }
    let zeros = 0
    for (let i = 0; i < k; i++) {
        zeros += data[i] ^ 1
    }
    let minZeros = zeros
    for (let i = k; i < n; i++) {
        zeros += (data[i] ^ 1) - (data[i - k] ^ 1)
        minZeros = Math.min(minZeros, zeros)
    }
    return minZeros
}