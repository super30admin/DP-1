public class HouseRobber {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        // Variable to represent to skip this house
        int skip = 0;

        // Variable to not skip this house
        int take = nums[0];

        for(int i=1; i< nums.length; i++){
            // Just the backup of the skip variable before overwriting it
            int temp = skip;

            // current skip will be max of previous skip and previous take
            skip= Math.max(skip, take);

            // current take will be previous skip + current element in nums array
            take = temp + nums[i];
        }

        return Math.max(skip,take);
    }
}
