function minSubArrayLen(target: number, nums: number[]): number {
    const n = nums.length
    let minLength = n + 1, sum = 0
    for (let left = 0, right = 0; right < n; right++) {
        sum += nums[right]
        while (sum >= target) {
            minLength = Math.min(minLength, right - left + 1)
            sum -= nums[left++]
        }
    }
    return minLength > n ? 0 : minLength
}