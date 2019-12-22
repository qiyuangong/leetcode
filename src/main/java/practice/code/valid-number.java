// Valid Number
// finite automata，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public boolean isNumber(String s) {
        int[][] transitionTable  = new int[][] {
            { -1, 0, 3, 1, 2, -1 }, // next states for state 0
            { -1, 8, -1, 1, 4, 5 },     // next states for state 1
            { -1, -1, -1, 4, -1, -1 },     // next states for state 2
            { -1, -1, -1, 1, 2, -1 },     // next states for state 3
            { -1, 8, -1, 4, -1, 5 },     // next states for state 4
            { -1, -1, 6, 7, -1, -1 },     // next states for state 5
            { -1, -1, -1, 7, -1, -1 },     // next states for state 6
            { -1, 8, -1, 7, -1, -1 },     // next states for state 7
            { -1, 8, -1, -1, -1, -1 }     // next states for state 8
        };

        int state = 0;
        for (int i = 0; i < s.length(); ++i) {
            final char ch = s.charAt(i);
            InputType inputType = InputType.INVALID;

            if (Character.isSpaceChar(ch))
                inputType = InputType.SPACE;
            else if (ch == '+' || ch == '-')
                inputType = InputType.SIGN;
            else if (Character.isDigit(ch))
                inputType = InputType.DIGIT;
            else if (ch == '.')
                inputType = InputType.DOT;
            else if (ch == 'e' || ch == 'E')
                inputType = InputType.EXPONENT;

            // Get next state from current state and input symbol
            state = transitionTable[state][inputType.ordinal()];

            // Invalid input
            if (state == -1) return false;
        }
        // If the current state belongs to one of the accepting (final) states,
        // then the number is valid
        return state == 1 || state == 4 || state == 7 || state == 8;

    }
    enum InputType {
        INVALID,    // 0
        SPACE,      // 1
        SIGN,       // 2
        DIGIT,      // 3
        DOT,        // 4
        EXPONENT,   // 5
        NUM_INPUTS  // 6
    }
}