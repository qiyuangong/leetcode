// Word Pattern
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;

        final Map<Character, String> map1 = new HashMap<>();
        final Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            final Character key1 = pattern.charAt(i);
            if (map1.containsKey(key1)) {
                final String value = map1.get(key1);
                if (!value.equals(words[i])) return false;
            } else {
                map1.put(key1, words[i]);
            }

            final String key2 = words[i];
            if (map2.containsKey(key2)) {
                final char value = map2.get(key2);
                if (value != pattern.charAt(i)) return false;
            } else {
                map2.put(key2, pattern.charAt(i));
            }
        }
        return true;
    }
}