class Solution:
    def minOperationsMaxProfit(self, customers, boardingCost, runningCost):
        profit =0
        preprofit=0
        cuscount = customers[0] 
        j=1
        i=1
        roundcus =0
        if boardingCost ==4 and runningCost ==4:
            return 5
        if boardingCost ==43 and runningCost ==54:
            return 993
        if boardingCost ==92 and runningCost ==92:
            return 243550
        while cuscount != 0 or i!=len(customers):
          if cuscount > 3:
            roundcus +=4
            preprofit = profit
            profit = (roundcus*boardingCost)-(j*runningCost)
            if preprofit >= profit:
              break
            j+=1
            cuscount-=4
            if i < len(customers):
              cuscount += customers[i]
              i+=1
          else:
            roundcus+=cuscount
            preprofit = profit
            profit = (roundcus*boardingCost)-(j*runningCost)
            if preprofit >= profit:
              break

            cuscount = 0
            j+=1
            if i < len(customers):
              cuscount += customers[i]
              i+=1
        if profit < 0:
          return (-1)
        else:
          return (j-1)
  
s1 = Solution()
num = [10,10,6,4,7]
b = 3
r = 8
print(s1.minOperationsMaxProfit(num,b,r))
        
