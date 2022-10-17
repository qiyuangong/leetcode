//015. 3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //create result list to store i,j,k
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        //sorting nums
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue; //if nums have same numbers, just check one time.
            } 
            
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                
                if (sum == 0) {
                    //if sum == 0, store i,j,k
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; //check anoter case
                    right--;
                    //if next number == now number
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    } 
                } else if (sum > 0) {
                    //if sum > 0, right--;
                    right--;
                } else {
                    //if sum < 0, left++;
                    left++;
                }
            }
        }
        
        return result; //return result list
    }
}
 
