function dietPlanPerformance(calories: number[], k: number, lower: number, upper: number): number {
    let sum = 0
    for (let i = 0; i < k; i++) {
        sum += calories[i]
    }
    let perf = sum < lower ? -1 : (sum > upper ? 1 : 0)
    for (let i = k; i < calories.length; i++) {
        sum += calories[i] - calories[i - k]
        perf += sum < lower ? -1 : (sum > upper ? 1 : 0)
    }
    return perf
}