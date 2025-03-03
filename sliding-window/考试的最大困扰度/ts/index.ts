function maxConsecutiveAnswers(answerKey: string, k: number): number {
    const countTable: [number, number] = [0, 0]
    let maxLength = 0
    for (let left = 0, right = 0; right < answerKey.length; right++) {
        countTable[answerKey.charCodeAt(right) >> 1 & 1]++;
        while (countTable[0] > k && countTable[1] > k) {
            countTable[answerKey.charCodeAt(left++) >> 1 & 1]--;
        }
        maxLength = Math.max(maxLength, right - left + 1)
    }
    return maxLength
}