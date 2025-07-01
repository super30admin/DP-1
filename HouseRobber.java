// TC - O(n)
// SC - O(1) - As we are only using skip and take variables

// We use house robber pattern to solve this.
// We use 2 variables skip and take instead of 2d array to reduce space complexity from O(n) to O(n1)
class HouseRobber {
    public int rob(int[] nums) {
        
        // base case
        if(nums==null || nums.length==0){
            return 0;
        }

        int n = nums.length;
        int skip = 0;
        int take = nums[0];

        for(int i = 1; i<n; i++){
            int tempSkip = skip;
            // finding skip and take based on previous row
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }

        return Math.max(skip, take);
    }
}