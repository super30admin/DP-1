// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int i=coins.length-1;
        int count=0;
        
        while(i>=0){
            if(amount>=coins[i]){
                count++;
                amount= amount-coins[i];
            }else{
                i--;
            }
        }
        
        if(amount==0){
            return count;
        }
            
        return -1;
        
    }
}