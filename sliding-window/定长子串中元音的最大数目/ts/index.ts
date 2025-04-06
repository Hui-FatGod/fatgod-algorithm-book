function maxVowels(s: string, k: number): number {
    const isVowel = (s: string): boolean => {
        return s === 'a' || s === 'e' || s === 'i' || s === 'o' || s === 'u'
    }
    let vowels = 0
    for (let i = 0; i < k; i++) {
        vowels += isVowel(s.charAt(i)) ? 1 : 0
    }
    let maxVowels = vowels
    for (let i = k; i < s.length; i++) {
        vowels += (isVowel(s.charAt(i)) ? 1 : 0) - (isVowel(s.charAt(i - k)) ? 1 : 0)
        maxVowels = Math.max(maxVowels, vowels)
    }
    return maxVowels
}