/*Time complexity - O(N)
 *Space complexity - O(N)
 *Ran on Leetocde - yes
 * 
 */ 
class Solution {
    
    public int rob(int[] nums) {    
        if (nums.length == 0 ) return 0 ; 
        // the repeated subproblem is max(current house + current-2 th house, current-1st house)
        int[] dp = new int[nums.length+1];
       
        
        // Base case initializations.
        dp[0] = 0;
        dp[1] = nums[0];
        
        
        for (int i = 1; i < nums.length; i++) {
              
            
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
             
        }
        //System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
