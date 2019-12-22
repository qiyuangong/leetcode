// Repeated DNA Sequences
// Time Complexity: O(n), Space Complexity: O(10n)
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;

        final Map<String, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length() - 9; ++i) {
            final String key = s.substring(i, i + 10);
            int value = counter.getOrDefault(key, 0);
            counter.put(key, value + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}