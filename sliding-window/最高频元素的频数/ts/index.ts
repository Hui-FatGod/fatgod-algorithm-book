function maxFrequency(nums: number[], k: number): number {
    nums.sort((n1, n2) => n1 - n2)
    let maxLength = 1, sumGap = 0
    for (let left = 0, right = 1; right < nums.length; right++) {
        sumGap += (nums[right] - nums[right - 1]) * (right - left)
        while (sumGap > k) {
            sumGap -= nums[right] - nums[left++];
        }
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return maxLength
}