//TC:O(n)
//SC:O(2n)
//succesfully ran on leetcode

import java.io.*;
import java.util.*;
class Solution {
    public int rob(int[] nums)
    {
        if(nums==null||nums.length==0)
            return 0;
        //keep track of the choose
        int c=0;
        //keep track of dont choose
        int dc=0;

        for(int x:nums)
        {
            //temporarily store dont chose in temp
            int temp=dc;

            //dont choose is maximum of the prevoius choose and dont choose
            dc=Math.max(c,dc);

            //choose is the array element value and dont choose which is temp
            c=x+temp;
        }

        //the answer is maximum of choose and dont choose
        return Math.max(c,dc);


     }
}
