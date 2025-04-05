const a = 'a'.charCodeAt(0)

function countOfSubstrings(word: string, k: number): number {
    const length = word.length
    const isVowel = (c: string): boolean => {
        return c === 'a' || c === 'e' || c === 'i' || c === 'o' || c === 'u'
    }
    const getSubs = (ge: number): number => {
        const countTable: number[] = Array(26).fill(0)
        let vowelTypes = 0, consonants = 0
        let subs = 0
        for (let left = 0, right = 0; right < length; right++) {
            if (isVowel(word.charAt(right))) {
                vowelTypes += ++countTable[word.charCodeAt(right) - a] === 1 ? 1 : 0
            } else {
                consonants++
            }
            while (vowelTypes === 5 && consonants >= ge) {
                subs += length - right
                if (isVowel(word.charAt(left))) {
                    vowelTypes -= --countTable[word.charCodeAt(left) - a] === 0 ? 1 : 0
                } else {
                    consonants--
                }
                left++
            }
        }
        return subs
    }
    return getSubs(k) - getSubs(k + 1)
}