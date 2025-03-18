function numSubarrayProductLessThanK(nums: number[], k: number): number {
    if (k <= 1) {
        return 0
    }
    let subs = 0, product = 1
    for (let left = 0, right = 0; right < nums.length; right++) {
        product *= nums[right]
        while (product >= k) {
            product /= nums[left++]
        }
        subs += right - left + 1
    }
    return subs
}