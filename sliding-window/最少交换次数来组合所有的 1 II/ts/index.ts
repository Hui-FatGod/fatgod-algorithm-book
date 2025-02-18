function minSwaps(nums: number[]): number {
    let k = 0
    for (const num of nums) {
        k += num
    }
    const n = nums.length
    if (k <= 1 || k == n) {
        return 0
    }
    let zeros = 0
    for (let i = 0; i < k; i++) {
        zeros += nums[i] ^ 1
    }
    let minZeros = zeros
    for (let i = k; i < n + k - 1; i++) {
        zeros += (nums[i % n] ^ 1) - (nums[(i - k) % n] ^ 1)
        minZeros = Math.min(minZeros, zeros)
    }
    return minZeros
}