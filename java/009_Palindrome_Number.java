class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) 
            return false;
        int temp = x;
        int len = 0;
        while (temp != 0) {
            temp /= 10;
            len ++;
        }
        temp = x;
        int left, right;
        for (int i = 0; i < len / 2; i++) {
            right = temp % 10;
            left = temp / (int) Math.pow(10, len - 2 * i - 1);
            left = left % 10;
            if (left != right)
                return  false;
            temp /= 10;
        }
        return true;
    }

    // Leetcode book
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while ( x / div >= 10) {
            div *= 10;
        }
        while (x !=0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            // Remove left and right number
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}

// simpler code 

class Solution {
    public boolean isPalindrome(int x) {
        int r,s=0,number=x;
        if(number<0){
            return false;
        }
        while (number!=0){
            r=number%10;
            s= s*10 +r;
            number/=10;
        }
        if (s==x){
            return true;
        }
        else {
            return false;
        }
    }
}
