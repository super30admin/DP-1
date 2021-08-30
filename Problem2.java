//T:O(n)
//S:O(1) (using 2 variables only)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int r, r1;
        r1 = 0;
        r= nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int current = Math.max(r, r1 + nums[i]);
            r1 = r;
            r = current;
        }
        
        return r;
    }
}
