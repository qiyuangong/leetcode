import java.util.*;

class Solution {
  /*
   * I have to save indice for each index.
   * So I use the HashMap<Integer, List<Integer>>
   */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        
		// use Iterator to find appropriate two indice.
		// Each list guarantee ascending.
		// So list.get(i) and list.get(i + 1) is minimum.
        Iterator<Integer> keys = map.keySet().iterator();
        boolean answer = false;
        
        while(keys.hasNext()) {
            int key = keys.next();
            List<Integer> list = map.get(key);
            
            if(list.size() < 2) continue;
            
            for(int i = 1; i < list.size(); i++) {
                int a = list.get(i - 1);
                int b = list.get(i);
                
                if(b - a <= k) {
                    answer = true;
                    break;
                }
            }
            if(answer) break;
        }
        return answer;
    }
}
