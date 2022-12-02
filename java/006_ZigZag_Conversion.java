//006_ZigZag_Conversion.java
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }

        String answer = "";
        String[] str_array = new String[numRows];

        for(int i=0;i<numRows;i++){
            str_array[i]="";
        }

        int mod = 2*numRows-2;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int index = i%mod;
            if(index >= numRows) {
                index = 2*(numRows-1) - index;
            }
            str_array[index]+=c;
        }

        for(int i=0;i<numRows;i++){
            answer += str_array[i];
        }

        return answer;
    }
}

