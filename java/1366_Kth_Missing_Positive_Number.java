class Solution {
    public int findKthPositive(int[] a, int k) 
    {
        int B[] = new int[a.length];
        
        //equation (A)
        //B[i]=a[i]-i-1
        
        
        //B[i]=number of missing numbers BEFORE a[i]
        for(int i=0;i<a.length;i++)
            B[i]=a[i]-i-1; //-1 is done as here missing numbers start from 1 and not 0
        
        //binary search upper bound of k
        //smallest value>=k
        
        int lo=0,hi=B.length-1;
        
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            
            if(B[mid]>=k)
                hi=mid-1;
            else
                lo=mid+1;
        }
        
        //lo is the answer
        
        /*now the number to return is a[lo]-(B[lo]-k+1) (EQUATION B)
        //where (B[lo]-k+1) is the number of steps we need to go back 
        //from lo to retrieve kth missing number, since we need to find 
        //the kth missing number BEFORE a[lo], we do +1 here as 
        //a[lo] is not a missing number when B[lo]==k
        //putting lo in equation(A) above
        //B[i]=a[i]-i-1
        //B[lo]=a[lo]-lo-1
        and using this value of B[lo] in equation B
        //we return a[lo]-(a[lo]-lo-1-k+1)
        we get lo+k as ans
        so return it*/
        
        return lo+k;
        
    }
}
