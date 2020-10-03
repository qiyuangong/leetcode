class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) 
    {
        LinkedList list = new LinkedList();
        for(int i = left; i <= right; i++)
        {
            if(isSelfDiving(i))
            list.add(i);
        }
        return list;
    }
    
    public boolean isSelfDiving(int num)
    {
            int digit = num % 10;
            int temp = num;
            boolean isTrue = true;
            while(temp != 0)
            {
                if(digit == 0 || num % digit != 0)
                {
                    isTrue = false;
                    break;
                }
                else
                {
                    temp /= 10;
                    digit = temp%10;
                }
            }
            return isTrue;

    }
        
}
