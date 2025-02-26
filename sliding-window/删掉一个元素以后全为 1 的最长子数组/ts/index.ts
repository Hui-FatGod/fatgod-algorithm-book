function longestSubarray(nums: number[]): number {
    let lastZeroIndex = -1, maxLength = 0
    for (let left = 0, right = 0; right < nums.length; right++) {
        if (nums[right] === 0) {
            left = lastZeroIndex + 1
            lastZeroIndex = right
        }
        maxLength = Math.max(maxLength, right - left)
    }
    return maxLength
}