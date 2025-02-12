function maxScore(cardPoints: number[], k: number): number {
    const n = cardPoints.length
    let score = 0
    for (let i = n - k; i < n; i++) {
        score += cardPoints[i]
    }
    let maxScore = score
    for (let i = n; i < n + k; i++) {
        score += cardPoints[i % n] - cardPoints[i - k]
        maxScore = Math.max(maxScore, score)
    }
    return maxScore
}