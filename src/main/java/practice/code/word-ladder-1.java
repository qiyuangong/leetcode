// Word Ladder
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<State> q = new LinkedList<>();
        HashSet<State> visited = new HashSet<>(); // 判重

        final Function<State, Boolean> stateIsValid = (State s) ->
                wordList.contains(s.word) || s.word.equals(endWord);
        final Function<State, Boolean> stateIsTarget = (State s) ->
                s.word.equals(endWord);

        final Function<State, HashSet<State> > stateExtend = (State s) -> {
            HashSet<State> result = new HashSet<>();

            char[] array = s.word.toCharArray();
            for (int i = 0; i < array.length; ++i) {
                final char old = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    // 防止同字母替换
                    if (c == array[i]) continue;

                    array[i] = c;
                    State newState = new State(new String(array), s.level+1);

                    if (stateIsValid.apply(newState) &&
                            !visited.contains(newState)) {
                        result.add(newState);
                    }
                    array[i] = old; // 恢复该单词
                }
            }

            return result;
        };

        State startState = new State(beginWord, 0);
        q.offer(startState);
        visited.add(startState);
        while (!q.isEmpty()) {
            State state = q.poll();

            if (stateIsTarget.apply(state)) {
                return state.level + 1;
            }


            HashSet<State> newStates = stateExtend.apply(state);
            for (State newState : newStates) {
                q.offer(newState);
                visited.add(newState);
            }
        }
        return 0;
    }

    static class State {
        String word;
        int level;

        public State(String word, int level) {
            this.word = word;
            this.level = level;
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (this.hashCode() != other.hashCode()) return false;
            if (!(other instanceof State)) return false;

            return this.word.equals(((State) other).word);
        }
    }
}