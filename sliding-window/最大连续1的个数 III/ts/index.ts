function longestOnes(nums: number[], k: number): number {
    let maxZeros = 0
    for (let left = 0, right = 0; right < nums.length; right++) {
        k -= nums[right] ^ 1
        while (k < 0) {
            k += nums[left++] ^ 1
        }
        maxZeros = Math.max(maxZeros, right - left + 1)
    }
    return maxZeros
}