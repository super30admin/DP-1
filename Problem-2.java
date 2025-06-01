// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int rob(int[] nums) {
        int chosen = 0;
        int notChosen = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = chosen;
            chosen = nums[i] + notChosen;
            notChosen = Math.max(temp,notChosen);
        }
        return Math.max(chosen, notChosen);
    }
}