function decrypt(code: number[], k: number): number[] {
    const n = code.length, absK = Math.abs(k)
    const pwd = Array(n)
    if (k == 0) {
        return pwd.fill(0)
    }
    const forward: boolean = k > 0
    const start = forward ? 1 : n - absK
    let sum = 0, index = 0
    for (let i = start; i < start + absK; i++) {
        sum += code[i]
    }
    pwd[index++] = sum
    const end = forward ? n + absK : 2 * n - 1
    for (let i = start + absK; i < end; i++) {
        sum += code[i % n] - code[(i - absK) % n]
        pwd[index++] = sum
    }
    return pwd
}