// Time Complexity : coin change : time - O(amount * no of coins) 
// Space Complexity : cpin change : time - O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Coin Change (donr on leetcode)
class Solution {
    
    public int coinChange(int[] coins, int amount) {
     int count = 0;
    IF(coins == null || coins.length==0)
        return -1;
        return helper(coins, amount, 0, count);
    }
    private int helper(coins, amount, index){
        if(amount == 0){
            
        }
        else if (anount < 0){
            
        }
    //case 1 choose the coin
        int choose = helper(coins,amopunt - coins[index], index, count+1);
        
    //case 2  dont choose the coin
        int notchoose = helper(coins, amount, index+1,count);
        
        if(choose == -1) return notchoose;
        else if (notchoose == -1) return choose;
        return Math.min(choose,notchoose);
        
        
        
        
        
}
}    

//House Robber -- Done on Leetcode
// Time Complexity :  : time - O(no of houses) 
// Space Complexity :  : time - O(n) new dp array
class Solution {
    public int rob(int[] nums) {
        
    int sum1 = 0;
    int sum2 = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0) 
              sum1+=nums[i];
      }
        for(int i=0; i<nums.length; i++){
            if(i%2 != 0) 
                sum2+=nums[i];
        }
        return sum1 > sum2 ? sum1 : sum2;
    
}
}
