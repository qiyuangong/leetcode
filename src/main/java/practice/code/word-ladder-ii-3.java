import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;

// Word Ladder II
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord,
                                          Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>(); // 判重
        HashMap<String, ArrayList<String>> father = new HashMap<>(); // DAG
        // only used by stateExtend()
        final HashMap<String, HashSet<String>> g = buildGraph(wordList);

        final Function<String, Boolean> stateIsValid = (String s) ->
                wordList.contains(s) || s.equals(endWord);
        final Function<String, Boolean> stateIsTarget = (String s) ->
                s.equals(endWord);

        final Function<String, List<String> > stateExtend = (String s) -> {
            List<String> result = new ArrayList<>();
            final int newDepth = visited.get(s) + 1;
            HashSet<String> list = g.get(s);
            if (list == null) return result;

            for (String newState : list) {
                if (stateIsValid.apply(newState)) {
                    if (visited.containsKey(newState)) {
                        final int depth = visited.get(newState);
                        if (depth < newDepth) {
                            // do nothing
                        } else if (depth == newDepth) {
                            result.add(newState);
                        } else {
                            throw new IllegalStateException("not possible to get here");
                        }

                    } else {
                        result.add(newState);
                    }
                }
            }

            return result;
        };

        List<List<String>> result = new ArrayList<>();
        q.offer(beginWord);
        visited.put(beginWord, 0);
        while (!q.isEmpty()) {
            String state = q.poll();

            // 如果当前路径长度已经超过当前最短路径长度，
            // 可以中止对该路径的处理，因为我们要找的是最短路径
            if (!result.isEmpty() && (visited.get(state) + 1) > result.get(0).size()) break;

            if (stateIsTarget.apply(state)) {
                ArrayList<String> path = new ArrayList<>();
                genPath(father, beginWord, state, path, result);
                continue;
            }
            // 必须挪到下面，比如同一层A和B两个节点均指向了目标节点，
            // 那么目标节点就会在q中出现两次，输出路径就会翻倍
            // visited.insert(state);

            // 扩展节点
            List<String> newStates = stateExtend.apply(state);
            for (String newState : newStates) {
                if (!visited.containsKey(newState)) {
                    q.offer(newState);
                    visited.put(newState, visited.get(state)+1);
                }
                ArrayList<String> parents = father.getOrDefault(newState, new ArrayList<>());
                parents.add(state);
                father.put(newState, parents);
            }
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

    private static HashMap<String, HashSet<String>> buildGraph(Set<String> dict) {
        HashMap<String, HashSet<String>> adjacency_list = new HashMap<>();
        for (String word: dict) {
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; ++i) {
                final char old = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    // 防止同字母替换
                    if (c == array[i]) continue;

                    array[i] = c;
                    String newWord = new String(array);

                    if (dict.contains(newWord)) {
                        HashSet<String> list = adjacency_list.getOrDefault(
                                word, new HashSet<>());
                        list.add(newWord);
                        adjacency_list.put(word, list);
                    }
                    array[i] = old; // 恢复该单词
                }
            }
        }
        return adjacency_list;
    }
}