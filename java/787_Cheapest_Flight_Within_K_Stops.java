class Solution {
    //using bellman ford
    
    public void computePrice(int[][]flights, int[] prices, int [] temp){
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            
            if(prices[u] != Integer.MAX_VALUE){
                if(prices[u] + price < temp[v]){
                    temp[v] = prices[u] + price;
                }
            }
        }
    }
    
    public void copyTempToPrice(int[] prices, int[] temp){
        for(int i=0; i<prices.length; i++){
            prices[i] = temp[i];
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        int[] temp = new int[n];
        
        Arrays.fill(prices, Integer.MAX_VALUE);
        Arrays.fill(temp, Integer.MAX_VALUE);
        
        prices[src] = 0;
        temp[src] = 0;
        
        for(int i=0; i<=k; i++){
            computePrice(flights, prices, temp);
            copyTempToPrice(prices, temp);
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}