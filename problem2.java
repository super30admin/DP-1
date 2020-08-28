
//Time Complexity= O(N)
//Space Complexity =O(1)
// Let us look at the case n = 1, clearly f(1) = A1.

// Now, let us look at n = 2, which f(2) = max(A1, A2).

// For n = 3, you have basically the following two options:

// Rob the third house, and add its amount to the first house's amount.

// Do not rob the third house, and stick with the maximum amount of the first two houses.

// Clearly, you would want to choose the larger of the two options at each step.

// Therefore, we could summarize the formula as following:

// f(k) = max(f(k – 2) + Ak, f(k – 1))

class Solution {
    public int rob(int[] nums) {

        if (nums.length == 0)
            return 0;

        int currMax = 0, prevMax = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }
}