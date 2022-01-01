// Time Complexity :O(N*S) s is the total amount
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    
    int[] cache;
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        
        //it save the min count change for amount >=1  
        cache = new int[amount + 1];
        
        return getMinCount(coins, amount);
    }
    
    
    public int getMinCount(int[] coins, int remainingAmount){
        if(remainingAmount < 0) return -1;
        
        if(remainingAmount == 0) return 0;
        
        if(cache[remainingAmount] != 0) return cache[remainingAmount];
        
        //find the min count, for this remaining amount
        int minCount = Integer.MAX_VALUE;
        
        //try every coin
        for(int coin : coins){
            
            int count = getMinCount(coins, remainingAmount - coin);
            //if min count found for remainign amoutn,
            //add the 1 to the count
            if(count >= 0){
                minCount = Math.min(minCount, count + 1);
            }
        }
        
        //save in the cache for 
        cache[remainingAmount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        
        return cache[remainingAmount];
    }
}







//Time complexity: O(N)
//Space complexity: O(N)

public int rob(int[] nums) {
    
	// Take an example of [2,1,1,2]
	
    if(nums.length == 0)
        return 0;
    
	if(nums.length == 1)
        return nums[0];
    
	if(nums.length == 2)
        return Math.max(nums[0],nums[1]);
    
    int[] dp = new int[nums.length]; // DP Array to store values dynamically
    dp[0] = nums[0]; // Initialize
    dp[1] = nums[1]; // Initialize
    
    for(int i = 2; i < nums.length; i++) {
        
        if(i == 2) // When i == 2, we have to take max between indexes (0 + 2) and (1)
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        else // When i > 2, we take max of these 3 possibilities
            dp[i] = Math.max(dp[i-2] + nums[i], Math.max(dp[i - 1], dp[i - 3] + nums[i]));
    }
    
    return dp[dp.length - 1]; // return last value in DP Array
    
}
}
