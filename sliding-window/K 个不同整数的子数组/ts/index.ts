function subarraysWithKDistinct(nums: number[], k: number): number {
    const n = nums.length
    const getSubs = (ge: number) => {
        const countTable: number[] = Array(n + 1).fill(0)
        let subs = 0, types = 0
        for (let left = 0, right = 0; right < n; right++) {
            types += ++countTable[nums[right]] === 1 ? 1 : 0
            while (types >= ge) {
                subs += n - right
                types -= --countTable[nums[left++]] === 0 ? 1 : 0
            }
        }
        return subs
    }
    return getSubs(k) - getSubs(k + 1)
}