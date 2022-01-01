public class CoinChange {
    Map<Integer,Integer> memo = new HashMap();
    
    public int coinChange(int[] coins, int amount) {
        int ans= helper(coins,amount);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
    
    public int helper(int [] coins, int amount){
         if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        
        if(amount==0){
            return 0;
        }
        
       
        
        int result=0;
        int minResult = -1;
        
        for(int i=0;i<coins.length;i++){
            if(amount-coins[i]>=0){
                result = helper(coins,amount-coins[i])+1;
                System.out.println(result);
                minResult = Math.min(minResult,result);
            }
        }
        
        memo.put(amount,minResult);
        return minResult;
    }
}