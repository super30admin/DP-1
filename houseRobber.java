class Solution {
    //tablular 
    //complexity time and space: O(N)
    public int rob(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[2][n+1];

        dp[0][0] = 0;// not to choose
        dp[1][0] = 0;// to choose

        for(int i=1;i<=n;i++){

            dp[0][i] = Math.max(dp[1][i-1], dp[0][i-1]);//not to choose
            dp[1][i] = nums[i-1] + dp[0][i-1]; //to choose
           
        } 

        // for( int i=0;i<2;i++){
        //     System.out.println("");
        //     for(int j=0;j<=n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        // }

        return Math.max(dp[0][n], dp[1][n]);
        
    }

    // Brute force 
    //complexity : (2^N)
    // private int helper(int[] nums, int count, int idx) {
    //     //base
    //     if (idx >= nums.length)
    //         return 0;
    //     //logic
    //     //to choose
    //     int toChoose = nums[idx] + helper(nums, count + nums[idx], idx + 2);
    //     // not to choose
    //     int notChoose = helper(nums, count, idx + 1);

    //     return Math.max(toChoose, notChoose);
    // }

    // public int rob(int[] nums) {

    //     int result = helper(nums, 0, 0);

    //     return result;
    // }
}