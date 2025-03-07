function maximumBeauty(nums: number[], k: number): number {
    nums.sort((n1, n2) => n1 - n2)
    let maxLength = 0
    for (let left = 0, right = 0; right < nums.length; right++) {
        while (nums[right] - nums[left] > k << 1) {
            left++
        }
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return maxLength
}