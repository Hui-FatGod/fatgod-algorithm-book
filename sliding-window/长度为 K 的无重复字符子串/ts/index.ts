function numKLenSubstrNoRepeats(s: string, k: number): number {
    if (k > s.length) {
        return 0
    }
    const table: number[] = Array(26).fill(0)
    let size = 0
    for (let i = 0; i < k; i++) {
        if (table[s.charCodeAt(i) - 97]++ === 0) {
            size++
        }
    }
    let number = size < k ? 0 : 1
    for (let i = k; i < s.length; i++) {
        if (table[s.charCodeAt(i) - 97]++ === 0) {
            size++
        }
        if (--table[s.charCodeAt(i - k) - 97] === 0) {
            size--
        }
        number += size < k ? 0 : 1
    }
    return number
}