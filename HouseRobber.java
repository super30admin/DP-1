//TC: O(n)
//SC: O(1)
//exponential search leads to time out and identified the repeated subproblems and implemented dp array 
// optimized the DP solution to get the constant space complexity.

class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < n; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }
        return Math.max(skip, take);
    }
}