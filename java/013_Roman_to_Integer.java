class Solution {
    public int romanToInt(String s) {
        int[] arr = new int['A' + 26];
        arr['I'] = 1;
        arr['V'] = 5;
        arr['X'] = 10;
        arr['L'] = 50;
        arr['C'] = 100;
        arr['D'] = 500;
        arr['M'] = 1000;

        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = arr[s.charAt(i)];
            result += prev > current ? -current : current;
            prev = current;
        }

        return result;
    }
}