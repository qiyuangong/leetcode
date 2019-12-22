// Word Ladder II
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord,
                                          Set<String> wordList) {
        // 当前层，下一层，用unordered_set是为了去重，例如两个父节点指向
        // 同一个子节点，如果用vector, 子节点就会在next里出现两次，其实此
        // 时 father 已经记录了两个父节点，next里重复出现两次是没必要的
        HashSet<String> current = new HashSet<>();
        HashSet<String> next = new HashSet<>();
        HashSet<String> visited = new HashSet<>(); // 判重
        HashMap<String, ArrayList<String>> father = new HashMap<>(); // DAG
        int level = -1; // 层次

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

        List<List<String>> result = new ArrayList<>();
        current.add(beginWord);
        while (!current.isEmpty()) {
            ++ level;
            // 如果当前路径长度已经超过当前最短路径长度，
            // 可以中止对该路径的处理，因为我们要找的是最短路径
            if (!result.isEmpty() && level + 1 > result.get(0).size()) break;

            // 1. 延迟加入visited, 这样才能允许两个父节点指向同一个子节点
            // 2. 一股脑current 全部加入visited, 是防止本层前一个节点扩展
            // 节点时，指向了本层后面尚未处理的节点，这条路径必然不是最短的
            for (String state : current)
                visited.add(state);

            for (String state : current) {
                if (stateIsTarget.apply(state)) {
                    ArrayList<String> path = new ArrayList<>();
                    genPath(father, beginWord, state, path, result);
                    continue;
                }
                // 扩展节点
                HashSet<String> newStates = stateExtend.apply(state);
                for (String newState : newStates) {
                    next.add(newState);
                    ArrayList<String> parents = father.getOrDefault(newState, new ArrayList<>());
                    parents.add(state);
                    father.put(newState, parents);
                }
            }
            current.clear();
            // swap
            HashSet<String> tmp = current;
            current = next;
            next = tmp;

        }
        return result;
    }
    private static void genPath(HashMap<String, ArrayList<String>> father,
                                String start, String state, List<String> path,
                                List<List<String>> result) {
        path.add(state);
        if (state.equals(start)) {
            if (!result.isEmpty()) {
                if (path.size() < result.get(0).size()) {
                    result.clear();
                } else if (path.size() == result.get(0).size()) {
                    // do nothing
                } else {
                    throw new IllegalStateException("not possible to get here");
                }
            }
            ArrayList<String> tmp = new ArrayList<>(path);
            Collections.reverse(tmp);
            result.add(tmp);
        } else {
            for (String f : father.get(state)) {
                genPath(father, start, f, path, result);
            }
        }
        path.remove(path.size() - 1);
    }
}