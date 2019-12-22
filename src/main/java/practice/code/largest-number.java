// Largest Number
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public String largestNumber(int[] nums) {
        final String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (String s1, String s2) -> {
            String leftRight = s1 + s2;
            String rightLeft = s2 + s1;
            return -leftRight.compareTo(rightLeft);
        });


        StringBuilder sb = new StringBuilder();
        for (final String s : strings) {
            sb.append(s);
        }

        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}