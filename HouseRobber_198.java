// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.

// Your code here along with comments explaining your approach
class HouseRobber_198 {
    public int rob(int[] nums) {
        
       int n= nums.length;
       int m = 2;
        
       int[][] dp=new int[n][m];
        
       //initi dp array with first house value as choosing and not choosing
        dp[0][0]=nums[0];
        dp[0][1]=0;
        
       for(int i=1;i<n;i++){
           for(int j=0;j<m;j++){
               if(j==0){
                    dp[i][j]=dp[i-1][1]+nums[i];
               }else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]);
               }
              
           }
       }
        
        return Math.max(dp[n-1][0],dp[n-1][1]);
          
    }
}