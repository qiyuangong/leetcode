class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] alphabets = new int[strs.length]['z' - 'a' + 1];
        
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            
            for(int j = 0; j < str.length(); j++) 
                alphabets[i][str.charAt(j) - 'a']++;
        }
        
        boolean[] visited = new boolean[strs.length];
        
        List<List<String>> answer = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++) {
            if(visited[i]) continue;
            
            List<String> list = new ArrayList<>();
            
            for(int j = i; j < strs.length; j++) {
                if(visited[j]) continue;
                if(isAnagram(alphabets[i], alphabets[j])) {
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
            
            answer.add(list);
        }
        
        return answer;
    }
    
    public boolean isAnagram(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
