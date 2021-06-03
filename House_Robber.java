// Time Complexity : O(N)
// Space Complexity : O(N)


class Solution {



    private int[] cache;
    public int rob(int[] nums) {

        this.cache = new int[100];

        /** initialize cache for storing the computed result  and using it later*/
        Arrays.fill(this.cache,-1);

        return robFrom(0,nums);

    }

    private int robFrom(int i, int nums[]) {

        /** all the houses are examined none left */
        if(i>=nums.length) {
            return 0;
        }


        /** return cache value to decrease computation  cost*/
        if(this.cache[i] > -1) {

            return this.cache[i];

        }

        int ans  = Math.max(this.robFrom(i+1,nums),  this.robFrom(i+2,nums) + nums[i]);

        /** store cache for using in the future */
        this.cache[i] = ans;

        return ans;



    }



}