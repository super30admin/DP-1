class Solution {
    //SC - O(1)
    //TC - O(n)
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int curr = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = curr; // store curr value in prev
            curr = Math.max(curr, prev + nums[i]); // calc maximum of robbing the current house (prev + nums[i]) and the value of previous house (curr)
            prev = temp;
        }

        return curr;
    }
}