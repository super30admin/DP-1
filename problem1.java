
//time-O(N*D): 
//Space- O(D)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res= new int[amount+1];
      int max= amount+1;
        Arrays.fill(res, max);
        res[0]=0;
        
        for(int i=1; i<=amount; i++){//#of denominations
            
            for(int j=0; j<coins.length; j++){ //all coins
                
                if(coins[j]<= i){
                    res[i]= Math.min(res[i], 1+ res[i-coins[j]]);
                }
                
                
            }
        }
        
        return res[amount]> amount? -1: res[amount];
        
        
    }
}