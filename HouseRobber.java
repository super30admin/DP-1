//Time Complexity: O(n)
//Space COmplexity: O(1)

public class HouseRobber {

    public int rob(int[] nums) {

        if(nums.length ==0 || nums == null){
            return 0;
        }

        int skip =0;
        int take = nums[0];

        for(int i=1;i<nums.length;i++){
            //don't choose
            //dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            int temp = skip;
            skip = Math.max(skip,take);

            //choose
            //  dp[i][1] = dp[i-1][0]+nums[i];
            take = nums[i]+temp;
        }


        //return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
        return Math.max(skip,take);

    }
}
