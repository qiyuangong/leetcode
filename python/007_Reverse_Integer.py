class Solution:
    # @return an integer

    # def reverse(self, x):
    #     max_int = 2147483647
    #     if x == 0:
    #         return 0
    #     isPos = True
    #     if x < 0:
    #         x *= (-1)
    #         isPos = False
    #     ltemp = []
    #     while x != 0:
    #         temp = x % 10
    #         ltemp.append(temp)
    #         x /= 10
    #     result = 0
    #     # the main solution
    #     for t in ltemp:
    #         result = result * 10 + t
    #     if result > max_int:
    #         result = 0
    #     if isPos:
    #         return result
    #     else:
    #         return -1 * result

    def reverse(self, x):
        # Note that in Python -1 / 10 = -1
       if x==0:
            return 0
        x=str(x)
        flag =False
        if '-' in x:
            flag=True
        x=x[::-1]
        x=x.replace('-','')
        
        if flag:
            res= int(f'-{x}')
        else:
            res = int(x)
        
        if abs(res) < 2**31 and res != 2**31 - 1:
            return res
        else:
            return 0
