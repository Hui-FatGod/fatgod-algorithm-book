function smallestRange(nums: number[][]): number[] {
    let length = 0, groups = nums.length
    nums.forEach(numsList => length += numsList.length)
    const pairs: number[][] = Array.from({length}, () => [0, 0])
    let start = 0
    for (let i = 0; i < nums.length; i++) {
        for (let num of nums[i]) {
            pairs[start][0] = num
            pairs[start++][1] = i
        }
    }
    pairs.sort((pair1, pair2) => pair1[0] - pair2[0])
    const countTable = Array(groups).fill(0)
    let leftBoundary = pairs[0][0], rightBoundary = pairs[length - 1][0] + 1
    for (let left = 0, right = 0; right < length; right++) {
        groups -= ++countTable[pairs[right][1]] === 1 ? 1 : 0
        while (groups === 0) {
            if (pairs[right][0] - pairs[left][0] < rightBoundary - leftBoundary) {
                leftBoundary = pairs[left][0]
                rightBoundary = pairs[right][0]
            }
            groups += --countTable[pairs[left++][1]] === 0 ? 1 : 0
        }
    }
    return [leftBoundary, rightBoundary]
}