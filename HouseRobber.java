class Solution {
    public int rob(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // Check if the array is empty or null; return -1 in such cases
        if (n == 0 || nums == null)
            return -1;

        // Initialize variables to keep track of the maximum amount when skipping and taking the current house
        int skip = 0;        // Maximum amount when skipping the current house
        int take = nums[0];  // Maximum amount when taking the current house

        // Iterate through the houses starting from the second one
        for (int i = 1; i < n; i++) {
            // Store the current value of 'skip' in a temporary variable
            int temp = skip;

            // Update 'skip' with the maximum of its current value and 'take'
            skip = Math.max(skip, take);

            // Update 'take' with the value of 'temp' (previous 'skip') plus the current house's value
            take = temp + nums[i];
        }

        // Return the maximum amount, considering both robbing and not robbing the last house
        return Math.max(skip, take);
    }
}

// Time Complexity: O(N), where N is the number of houses
// Space Complexity: O(1), as only a constant amount of extra space is used
