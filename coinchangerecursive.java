
// here time complexity is o(2^n) 
// here space complexity is o(1)
// this is a recursive approach of the coin change problem
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins,amount,0,0);
    }
    public int helper(int [] coins,int amount,int i, int min)
    {
        if(amount<0||i>coins.length-1)
            return -1;
        //base case
        if(amount==0)
            return min;
        
        //case1 coin is chosen
        int case1= helper(coins, amount-coins[i],i,min+1);
        // case2 coin is not chosen
        int case2=helper(coins,amount,i+1,min);
        if(case1==-1)
        {
            return case2;
        }
        else if(case2==-1)
        {
            return case1;
        }
        else
            return Math.min(case1,case2);
    }
}