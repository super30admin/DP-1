//Time Complexity: O(n) — You iterate through the nums array once.
//Space Complexity: O(1) — Only constant space is used (prev, curr, and temp).

//Use two variables: prev to store the max loot till house i-2, and curr for house i-1.
//For each house from index 2 onward, update curr = max(curr, nums[i] + prev) to decide rob or skip.
//Return curr which holds the maximum money that can be robbed without alerting the police.

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
