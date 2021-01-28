//Time complexity: O(n * 2) => O(n)
//Space complexity: O(2n) =>  o(n)
//n = length of nums

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int m = nums.length;
        int n = 2; // choose and not choose
        
        int[][] dp = new int[m][n];
        //fill the 1st row with initial values in dp
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    int prevDC = dp[i-1][1];
                    dp[i][0] = nums[i] + prevDC;
                }
                else{
                    int prevC = dp[i-1][0];
                    int prevDC = dp[i-1][1];
                    
                    dp[i][1] = Math.max(prevC, prevDC);
                }
            }
        }
        
        //return max of choose, not choose of last row
        return Math.max(dp[m -1][0], dp[m -1][1]);
    }
}