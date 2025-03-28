function minSizeSubarray(nums: number[], target: number): number {
    let total = 0
    nums.forEach(num => total += num)
    const remainder = target % total, n = nums.length
    let minLength = n + 1, sum = 0
    for (let left = 0, right = 0; right < n * 2; right++) {
        sum += nums[right % n]
        while (sum >= remainder) {
            if (sum === remainder) {
                minLength = Math.min(minLength, right - left + 1)
            }
            sum -= nums[left++ % n]
        }
    }
    return minLength > n ? -1 : minLength + Math.floor(target / total) * n
}