class Solution {
  
  // Time complexity: O(n)
  // Space complexity: O(n)
  
    public int rob(int[] nums) {
        
        if(nums.length == 0) 
            return -1;
        
        if(nums.length == 1) 
            return nums[0];
        
        int [] dp = new int [nums.length];
        
        //for 0th index, only one house is present so choose it 
        dp[0] = nums[0];
        
        //for 1st index we have 2 houses to rob, can choose the one with higher value
        dp[1] = Math.max(nums[0], nums[1]);    
        
        for(int i=2; i < nums.length; i++) {
        
            //choose  i-2 + i    
            int choose = nums[i] + dp[i-2];
            
            //Previous value
            int notChoose = dp[i-1];
            
            dp[i] = Math.max(choose, notChoose);
        }
        
        return dp[nums.length - 1];
    }
}
