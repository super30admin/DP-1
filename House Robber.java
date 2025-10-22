// Instead of a dp array, we just keep track of two variables: previous and current max.
// For each house, we decide to skip or rob it and update our variables accordingly.
// At the end, curr holds the maximum money we can rob.

// time o(n)
// space o(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
       
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++){
            int temp = curr;
            curr = Math.max(temp, nums[i]+prev);
            prev = temp;
        }

        return curr;
    }
}
