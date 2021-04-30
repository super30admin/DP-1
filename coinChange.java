//Time Complexity: o(n)
// Space Complexity: o(n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0 ) return 0;
        return recur(coins, 0, amount, 0);
         
    }
    
    private int recur( int[] coins, int index,int amount, int min){
        if(amount == 0){
            return min;
        }
        if(index == coins.length || amount<0) return -1;
        //choosing the value
        int case1 = recur(coins,index, amount-coins[index], min+1 );
        // Not choosing the value
        int case2 = recur(coins, index+1, amount, min);
        
        if(case1 == -1) return case2;
        else if(case2 == -1) return case1;
        
        return Math.min(case1,case2);
    }
}
