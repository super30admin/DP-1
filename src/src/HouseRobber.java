import java.util.Arrays;

public class HouseRobber {


    /*TC : O(N) where N is the number of houses
SC : O(N) for the recursive stack call and the cache array
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */

/*
The approach used here is bottom up one. At any stage of robbing, the robber has two choices :
  1)To rob the current house, in this case the robber will skip the next house
  2)To skip the current house, in this case, the next house can be robbed if wanted to.
  What we do here is that we start from the last house and for any house before that,
  we know that the maximum money that can be stolen will be maximum of following two values
    1)current house money + max for house i+2
    2)maximum money till house i+1;
    we store these answers for each house in a cache so that we are not doing repititve computations

  */
    public int rob_recusrion_memoization(int[] nums) {

        int[] cache = new int[100];
        Arrays.fill(cache, -1);

        return this.robFrom(0, nums, cache);
    }

    private int robFrom(int i, int[] nums, int[] cache) {


        if (i >= nums.length)
            return 0;

        if (cache[i] > -1)
            return cache[i];

        int ans = Math.max(this.robFrom(i + 1, nums, cache), this.robFrom(i + 2, nums, cache) + nums[i]);

        cache[i] = ans;
        return ans;
    }


  /*  TC : O(N) where N is the number of houses
SC : O(N) for the cache array
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No*/

/*The approach taken is similar to the recursive one, just to avoid stack overflow problems of recursion for very
    large number of houses, we use an iterative approach.
  The underlying theme of the problem is the same.
  Here, we need to initialize two values. Ans at index = nums.length should be zero as the money that can be stolen before starting is 0.
  and value at index = nums.length-1 should be money at house of index = nums.length-1, as there is no choice as such, that's our last house

 */


    public int rob_dp(int[] nums) {

        int[] cache = new int[100+1];
        Arrays.fill(cache, -1);
        cache[nums.length]=0;
        cache[nums.length-1]=nums[nums.length-1];

        for(int i=nums.length-2; i>=0; i--)
            cache[i]= Math.max(cache[i+2] + nums[i], cache[i+1]);

        return cache[0];

    }


     /*  TC : O(N) where N is the number of houses
SC : O(N) for the cache array
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No*/

/*
* The solution is same as the dp solution before but with space optmization. Here, we are using only the next two values to calculate the current values
* and at the end we are returning the current value, hence we dont have to use an array to store all the values.
* We can just use two variables that will always hold the values of the next two houses and we update these values at every iteration.*/

    public int rob_dp_optimised(int[] nums) {

        int aheadbyTwo = 0;
        int aheadbyOne = nums[nums.length-1];
        int currentHouse=0;
        for(int i=nums.length-2; i>=0; i--)
        {

            currentHouse = Math.max(aheadbyTwo+ nums[i], aheadbyOne);
            aheadbyTwo = aheadbyOne;
            aheadbyOne = currentHouse;

        }

        return aheadbyOne;

    }
}
