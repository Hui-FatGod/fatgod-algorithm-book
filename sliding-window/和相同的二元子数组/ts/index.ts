function numSubarraysWithSum(nums: number[], goal: number): number {
    const n = nums.length
    let gtSum = 0, geSum = 0
    let gtSubs = 0, geSubs = 0
    for (let gtLeft = 0, geLeft = 0, right = 0; right < n; right++) {
        gtSum += nums[right]
        while (gtSum > goal) {
            gtSubs += n - right
            gtSum -= nums[gtLeft++]
        }
        geSum += nums[right]
        while (geSum >= goal && geLeft <= right) {
            geSubs += n - right
            geSum -= nums[geLeft++]
        }
    }
    return geSubs - gtSubs
}