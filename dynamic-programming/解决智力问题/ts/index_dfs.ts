const NOT_CALC = -1

function mostPoints(questions: number[][]): number {
    const n = questions.length
    const memory: number[] = Array(n).fill(NOT_CALC)
    const dfs = (i: number): number => {
        if (i >= n) {
            return 0
        }
        if (i === n - 1) {
            return questions[n - 1][0]
        }
        if (memory[i] !== NOT_CALC) {
            return memory[i]
        }
        return memory[i] = Math.max(questions[i][0] + dfs(i + questions[i][1] + 1), dfs(i + 1))
    }
    return dfs(0)
}

export {}