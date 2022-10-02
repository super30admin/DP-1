
class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        //Dynamic Programming
        //Two cases: Rob and Do not rob
        //DoNotRob = Max(Previous robbed and not robbed amount) // Just what was the last max robbed amount
        //rob = (Previous Do Not robbed amount + current house amount) // Not robbing adjuscent houses

        int[][] dp = new int[nums.length][2];

        dp[0][0] = 0; // starting amount when not robbing
        dp[0][1] = nums[0]; 

        for(int i = 1; i < nums.length; i++){
            //Do not rob
            dp[i][0] = Integer.max(dp[i-1][0], dp[i-1][1]);
            //Rob
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        //maximum from last row is the max robbed amount
        return Integer.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)