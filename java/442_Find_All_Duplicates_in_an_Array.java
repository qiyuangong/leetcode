class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            int possibleVal = Math.abs(nums[i]);

            if(nums[possibleVal - 1] < 0) {
                ans.add(possibleVal);
            }
            nums[possibleVal - 1] = -1 * nums[possibleVal - 1];
        }
        return ans;
    }
}
