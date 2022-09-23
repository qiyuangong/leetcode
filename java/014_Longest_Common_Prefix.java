class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result ="";
        String temp = "";
        int c = 0;
        boolean check = true;
        while(true){
            for(int i = 0; i<strs.length; i++){
                if(c>=strs[i].length()){
                    check = false;
                    break;
                }
                if(i==0){
                    temp = Character.toString(strs[0].charAt(c));
                }
                if(!temp.equals(Character.toString(strs[i].charAt(c)))){
                    check = false;
                    break;
                }
                if(i==strs.length-1){
                    result += temp;
                }
            }
            if(!check){
                break;
            }
            c++;
        }
        return result;
        
    }
}