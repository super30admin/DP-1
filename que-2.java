// Time Complexity :O(n)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        
        int C = 0,DC = 0;
        for(int x: nums){
            int temp = DC;
            DC = Math.max(C,DC);
            C = x + temp;
            
            }
        
        return Math.max(C,DC);
    }
}

//With Matrix
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int n = nums.length; int m = 2;
        int[][]dp =new int[n][m];
        dp[0][0]= nums[0];
        dp[0][1]=0;
        for(int i = 1; i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    dp[i][j]=nums[i] + dp[i-1][1];
                }else{
                    dp[i][j]= Math.max(dp[i-1][0],dp[i-1][j]);
                }
            }
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}