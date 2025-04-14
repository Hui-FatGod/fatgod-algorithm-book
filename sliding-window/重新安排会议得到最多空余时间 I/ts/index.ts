function maxFreeTime(eventTime: number, k: number, startTime: number[], endTime: number[]): number {
    const n = startTime.length
    const getFreeTime = (index: number): number => {
        if (index === 0) {
            return startTime[0]
        }
        if (index === n) {
            return eventTime - endTime[n - 1]
        }
        return startTime[index] - endTime[index - 1]
    }
    let freeTime = 0
    for (let i = 0; i < k + 1; i++) {
        freeTime += getFreeTime(i)
    }
    let maxFreeTime = freeTime
    for (let i = k + 1; i < n + 1; i++) {
        freeTime += getFreeTime(i) - getFreeTime(i - k - 1)
        maxFreeTime = Math.max(maxFreeTime, freeTime)
    }
    return maxFreeTime
}