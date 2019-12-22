// Valid Anagram
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        final int[] map = new int[ALPHABET_SIZE];

        for (int i = 0; i < s.length(); ++i) {
            ++map[s.charAt(i) - 'a'];
            --map[t.charAt(i) - 'a'];
        }
        for (int x : map) {
            if (x != 0) return false;
        }
        return true;
    }
    private static final int ALPHABET_SIZE = 26;
}
