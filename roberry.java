/*Time complexity
O(N)
Space Complexity
O(N)
*/
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,dp,n-1);
    }
    public int solve(int[] nums,int dp[],int i){
        int prev=nums[0];
        int prev2=0;
        for(int j=1;j<=i;j++){
            int pick=nums[j];
            if(j>1){
  
                pick+=prev2;
            }
            int nonpick=0+prev;
            int curr=Math.max(pick,nonpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
        
    }
}