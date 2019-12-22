// Happy Number
// Time complexity: ?, Space complexity: ?
public class Solution {
    public boolean isHappy(int n) {
        final Set<Integer> existed = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (existed.contains(sum)) {
                return sum == 1;
            } else {
                existed.add(sum);
                n = sum;
            }
        }
    }
}