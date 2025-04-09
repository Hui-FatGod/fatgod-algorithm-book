function isPalindrome(s: string): boolean {
    for (let left = 0, right = s.length - 1; left < right; left++, right--) {
        while (left < right && !isNumberOrLetter(s.charAt(left))) {
            left++
        }
        while (left < right && !isNumberOrLetter(s.charAt(right))) {
            right--
        }
        if (left !== right && s.charAt(left).toLowerCase() !== s.charAt(right).toLowerCase()) {
            return false
        }
    }
    return true
}

function isNumberOrLetter(s: string): boolean {
    const c = s.charCodeAt(0)
    return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)
}