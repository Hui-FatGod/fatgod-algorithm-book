function divisorSubstrings(num: number, k: number): number {
    const numStr = String(num)
    let divisor = 0
    for (let i = 0; i < k; i++) {
        divisor += Math.pow(10, k - i - 1) * (numStr.charCodeAt(i) - 48)
    }
    let cnt = divisor !== 0 && num % divisor === 0 ? 1 : 0
    for (let i = k; i < numStr.length; i++) {
        divisor -= Math.pow(10, k - 1) * (numStr.charCodeAt(i - k) - 48)
        divisor *= 10
        divisor += numStr.charCodeAt(i) - 48
        cnt += divisor !== 0 && num % divisor === 0 ? 1 : 0
    }
    return cnt;
}