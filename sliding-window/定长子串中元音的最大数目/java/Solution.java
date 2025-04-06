class Solution {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int vowels = 0;
        for (int i = 0; i < k; i++) {
            vowels += isVowel(chars[i]) ? 1 : 0;
        }
        int maxVowels = vowels;
        for (int i = k; i < chars.length; i++) {
            vowels += (isVowel(chars[i]) ? 1 : 0) - (isVowel(chars[i - k]) ? 1 : 0);
            maxVowels = Math.max(maxVowels, vowels);
        }
        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}