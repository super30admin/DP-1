
//TC - O(n)
//SC - O(1)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

public class HouseRobber {

    public int rob(int[] nums) {
        int skip=0;
        int take = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp+nums[i];
        }
        return Math.max(skip,take);

    }
}
