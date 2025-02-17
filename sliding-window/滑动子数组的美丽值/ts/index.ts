const BIAS: number = 50

function getSubarrayBeauty(nums: number[], k: number, x: number): number[] {
    const n = nums.length
    const counts: number[] = Array(2 * BIAS + 1).fill(0)
    for (let i = 0; i < k; i++) {
        counts[BIAS + nums[i]]++
    }
    const getBeauty = (x: number): number => {
        for (let i = 0; i < BIAS; i++) {
            x -= counts[i]
            if (x <= 0) {
                return -BIAS + i
            }
        }
        return 0
    }
    const beauties: number[] = Array(n - k + 1)
    let index = 0
    beauties[index++] = getBeauty(x)
    for (let i = k; i < n; i++) {
        counts[BIAS + nums[i]]++
        counts[BIAS + nums[i - k]]--
        beauties[index++] = getBeauty(x)
    }
    return beauties
}