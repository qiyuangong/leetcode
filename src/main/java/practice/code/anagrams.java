// Anagrams
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final HashMap<String, ArrayList<String>> group = new HashMap<>();
        for (final String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);

            final String key = new String(tmp);
            if (!group.containsKey(key)) {
                group.put(key, new ArrayList<>());
            }
            group.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : group.entrySet()) {
            final ArrayList<String> list = entry.getValue();
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}