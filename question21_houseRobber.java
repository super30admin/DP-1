package DynamicProgramming1;

public class question21_houseRobber {

    /*
    Recursive Approch: But the time limit wil be exceeded
        Time Complexity: O(n)
        Space Complexity: O(1)

    */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        return robHelper(nums, 0, 0);
    }

    private int robHelper(int nums[], int index, int robbings) {
        // Base Case
        if(index >= nums.length) return robbings;

        // Logic
        //If the house is robbed
        int case1 = robHelper(nums, index + 2, robbings + nums[index]);
        //If the house is not robbed
        int case2 = robHelper(nums, index + 1, robbings);

        return Math.max(case1, case2);
    }

    /*
    Dynamic Programming Approch: But the time limit wil be exceeded
        Time Complexity: O(n)
        Space Complexity: O(1)
        Amount is not the decision making criteria here
        House is the only decision making criteria.

    */
    public int robDP(int[] nums) {
        if(nums == null) return 0;

        int dp[][] = new int[nums.length][2];
        dp[0][1] = nums[0];

        for(int i = 1 ; i < nums.length ; i++) {

            // if you do not choose
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

            // if you choose
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    /*
    Without using DP. Just used two variables
    */
    public int rob2variables(int[] nums) {
        if(nums == null) return 0;

        int skip = 0;
        int take = nums[0];

        for(int i = 1 ; i < nums.length ; i++) {
            int prevSkip = skip;
            // if you do not choose
            skip = Math.max(skip, take);

            // if you choose
            take = prevSkip + nums[i];
        }
        return Math.max(skip, take);
    }

    public static void main(String[] args) {

    }
}
