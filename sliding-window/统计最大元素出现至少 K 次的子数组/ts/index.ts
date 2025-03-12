function countSubarrays(nums: number[], k: number): number {
    const n = nums.length
    let max = nums[0]
    nums.forEach(num => max = Math.max(max, num))
    let maxCount = 0, subs = 0
    for (let left = 0, right = 0; right < n; right++) {
        maxCount += nums[right] === max ? 1 : 0
        while (maxCount >= k) {
            subs += n - right
            maxCount -= nums[left++] === max ? 1 : 0
        }
    }
    return subs
}