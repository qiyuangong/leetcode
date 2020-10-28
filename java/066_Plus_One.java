class Solution {
    public int[] plusOne(int[] digits) {
            return addToDigit(digits, digits.length - 1);
        }

        private int[] addToDigit(int[] digits, int index) {
            if (index == -1) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                for (int i = 0; i < digits.length; i++) {
                    newDigits[i + 1] = digits[i];
                }
                return newDigits;
            }
            if (digits[index] == 9) {
                digits[index] = 0;
                return addToDigit(digits, index - 1);
            } else {
                digits[index]++;
                return digits;
            }
        }
}
