function minOperations(nums: number[], x: number): number {
    const n = nums.length;
    let sum = -x
    for (const num of nums) {
        sum += num
    }
    if (sum == 0) {
        return n
    }
    if (sum < 0) {
        return -1
    }
    let maxLength = -1
    for (let left = 0, right = 0; right < n; right++) {
        sum -= nums[right]
        while (sum < 0) {
            sum += nums[left++]
        }
        if (sum == 0) {
            maxLength = Math.max(maxLength, right - left + 1)
        }
    }
    return maxLength < 0 ? -1 : n - maxLength
}