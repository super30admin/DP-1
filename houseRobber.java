/*
Runtime complexity - O(N) - we are looping the nums array, N - length of nums array (num of house)
Space complexity - O(1) - We are only using two variable to store the amount robbed from previous house.
*/

class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(nums[i] + rob1, rob2); // Take the maximum amount robbed from neibhoring house but at the same time ignore consecutive house.
            rob1 = rob2; // This is to ensure we are not picking the adjacent house.
            rob2 = temp;
        }
        return rob2;
    }
}
