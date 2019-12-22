// Repeated DNA Sequences
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final List<String> result = new ArrayList<>();
        if (s.length() < LEN) return result;

        final Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('A', 0);
        charMap.put('C', 1);
        charMap.put('G', 2);
        charMap.put('T', 3);

        final Map<Integer, Character> intMap = new HashMap<>();
        intMap.put(0, 'A');
        intMap.put(1, 'C');
        intMap.put(2, 'G');
        intMap.put(3, 'T');

        final Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length() - LEN + 1; ++i) {
            final String key = s.substring(i, i + 10);
            final int hashValue = strToInt(key, charMap);
            counter.put(hashValue, counter.getOrDefault(hashValue, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(intToStr(entry.getKey(), intMap));
            }
        }
        return result;
    }

    // perfect hash, no collisions
    private static int strToInt(String s, Map<Character, Integer> charMap) {
        assert s.length() == LEN;
        int x = 0;
        for (int i = 0; i < LEN; ++i) {
            final char ch = s.charAt(i);
            x = (x << 2) + charMap.get(ch);
        }
        return x;
    }
    private String intToStr(int x, Map<Integer, Character> intMap) {
        final StringBuilder sb = new StringBuilder();

        while (x > 0) {
            final char ch = intMap.get(x & 3);
            sb.append(ch);
            x >>= 2;
        }
        while (sb.length() < LEN) sb.append(intMap.get(0));
        return sb.reverse().toString();
    }
    private static final int LEN = 10;
}