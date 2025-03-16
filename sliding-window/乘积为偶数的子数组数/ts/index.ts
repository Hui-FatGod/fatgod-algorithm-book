function evenProduct(nums: number[]): number {
    const n = nums.length
    let subs = 0
    for (let left = 0, right = 0; right < n; right++) {
        if (nums[right] % 2 === 0) {
            subs += (n - right) * (right - left + 1)
            left = right + 1
        }
    }
    return subs
}