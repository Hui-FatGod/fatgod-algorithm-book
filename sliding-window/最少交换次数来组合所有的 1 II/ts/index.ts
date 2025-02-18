function minSwaps(nums: number[]): number {
    let k = 0
    for (const num of nums) {
        k += num
    }
    const n = nums.length
    if (k <= 1 || k == n) {
        return 0
    }
    let swaps = 0
    for (let i = 0; i < k; i++) {
        swaps += nums[i] ^ 1
    }
    let minSwaps = swaps
    for (let i = k; i < n + k - 1; i++) {
        swaps += (nums[i % n] ^ 1) - (nums[(i - k) % n] ^ 1)
        minSwaps = Math.min(minSwaps, swaps)
    }
    return minSwaps
}