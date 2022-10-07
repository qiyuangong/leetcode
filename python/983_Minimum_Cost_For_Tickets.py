class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        @functools.lru_cache(None)
        def dp(i, cost_cover_till_day):
            
            if i >= len(days):
                return 0
            
            if days[i] <= cost_cover_till_day:
                return dp(i+1, cost_cover_till_day)
            else:
                one_day_cost = costs[0] + dp(i+1, days[i])
                seven_day_cost = costs[1] + dp(i+1, days[i]+6)
                thirty_day_cost = costs[2] + dp(i+1, days[i]+29)
                
                return min(one_day_cost, seven_day_cost, thirty_day_cost)
            
        
        return dp(0, 0)