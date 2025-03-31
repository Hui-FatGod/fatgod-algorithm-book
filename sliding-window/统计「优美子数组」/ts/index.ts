function numberOfSubarrays(nums: number[], k: number): number {
    const n = nums.length
    let gtOddCount = 0, geOddCount = 0
    let gtSubs = 0, geSubs = 0
    for (let gtLeft = 0, geLeft = 0, right = 0; right < n; right++) {
        gtOddCount += nums[right] & 1
        while (gtOddCount > k) {
            gtSubs += n - right
            gtOddCount -= nums[gtLeft++] & 1
        }
        geOddCount += nums[right] & 1
        while (geOddCount >= k) {
            geSubs += n - right
            geOddCount -= nums[geLeft++] & 1
        }
    }
    return geSubs - gtSubs
}