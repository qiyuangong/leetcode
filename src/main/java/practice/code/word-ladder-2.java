// Word Ladder
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> current = new LinkedList<>(); // 当前层
        Queue<String> next = new LinkedList<>();    // 下一层
        HashSet<String> visited = new HashSet<>();  // 判重

        int level = -1;  // 层次

        final Function<String, Boolean> stateIsValid = (String s) ->
                wordList.contains(s) || s.equals(endWord);
        final Function<String, Boolean> stateIsTarget = (String s) ->
                s.equals(endWord);

        final Function<String, HashSet<String> > stateExtend = (String s) -> {
            HashSet<String> result = new HashSet<>();

            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; ++i) {
                final char old = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    // 防止同字母替换
                    if (c == array[i]) continue;

                    array[i] = c;
                    String newState = new String(array);

                    if (stateIsValid.apply(newState) &&
                            !visited.contains(newState)) {
                        result.add(newState);
                    }
                    array[i] = old; // 恢复该单词
                }
            }

            return result;
        };

        current.offer(beginWord);
        visited.add(beginWord);
        while (!current.isEmpty()) {
            ++level;
            while (!current.isEmpty()) {
                // 千万不能用 const auto&，pop() 会删除元素，
                // 引用就变成了悬空引用
                String state = current.poll();

                if (stateIsTarget.apply(state)) {
                    return level + 1;
                }

                HashSet<String> newStates = stateExtend.apply(state);
                for (String newState : newStates) {
                    next.offer(newState);
                    visited.add(newState);
                }
            }
            // swap
            Queue<String> tmp = current;
            current = next;
            next = tmp;
        }
        return 0;
    }
}