class Solution {
    public int rob(int[] nums) {
        

        int tmp;
        int prev = 0;
        int prev2prev = 0;

        for(int  i : nums){
            tmp = prev;
            prev = Math.max(prev,prev2prev+i);
            prev2prev = tmp;
        }

        return prev;

    }
}