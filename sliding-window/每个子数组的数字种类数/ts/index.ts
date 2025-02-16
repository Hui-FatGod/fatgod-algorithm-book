function distinctNumbers(nums: number[], k: number): number[] {
    const n = nums.length
    const ans = Array(n - k + 1)
    const map: Map<number, number> = new Map()
    for (let i = 0; i < k; i++) {
        map.set(nums[i], (map.get(nums[i]) || 0) + 1)
    }
    let index = 0
    ans[index++] = map.size
    for (let i = k; i < n; i++) {
        map.set(nums[i], (map.get(nums[i]) || 0) + 1)
        const cnt = map.get(nums[i - k])!
        if (cnt <= 1) {
            map.delete(nums[i - k])
        } else {
            map.set(nums[i - k], cnt - 1)
        }
        ans[index++] = map.size
    }
    return ans
}