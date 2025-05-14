const NOT_CALC = -1

function deleteAndEarn(nums: number[]): number {
    const countTable: Map<number, number> = new Map()
    for (let num of nums) {
        countTable.set(num, (countTable.get(num) || 0) + 1)
    }
    const newNums: number[] = []
    let start = 0
    for (let num of countTable.keys()) {
        newNums[start++] = num
    }
    newNums.sort((a, b) => a - b)
    const n = newNums.length
    const memory: number[] = Array(n).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i < 0) {
            return 0
        }
        if (i === 0) {
            return newNums[0] * countTable.get(newNums[0])!
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        const points = newNums[i] * countTable.get(newNums[i])!
        return memory[i] = newNums[i] - newNums[i - 1] > 1 ? points + dfs(i - 1)
            : Math.max(points + dfs(i - 2), dfs(i - 1))
    }
    return dfs(n - 1)
}

export {}