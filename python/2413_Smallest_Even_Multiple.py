class Solution:
    def smallestEvenMultiple(self, n: int) -> int:
        """
            n : positive integer
            return : smallest positive integer that is a multiple of both 2 and n
        """
        if n % 2 == 0:
            # if n is alreay muliply by 2 
            # return itself
            return n
        
        # if previous condition is false 
        # n * 2 is the smallest positive integer.
        return n * 2
        
