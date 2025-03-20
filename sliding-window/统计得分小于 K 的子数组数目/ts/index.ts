function countSubarrays(nums: number[], k: number): number {
    let subs = 0, sum = 0
    for (let left = 0, right = 0; right < nums.length; right++) {
        sum += nums[right]
        while ((right - left + 1) * sum >= k) {
            sum -= nums[left++]
        }
        subs += right - left + 1
    }
    return subs
}