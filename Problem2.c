
/* Problem Statement: 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

 * Best Solution 
 * Time Complexity : O(n) 
 * Space Complexity : O(k) where k = 3 (extra variables needed )
 */

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

/* Macro for calculating max value among 2 numbers */
#ifndef max
    #define max(a,b) ((a) > (b) ? (a) : (b))
#endif

/* The recursive helper function for calculating the maximum money which can be collected
 * while going through the houses following the conditions */
int rob_helper_func(int *nums, int numsSize, int max_cnt, int idx, bool prevChosen) {
    /* ret1 : return count from function having prevChosen as true 
     * ret2 : return count from function having prevChosen as false
     */
    int ret1 = 0, ret2 = 0;
    
    /* Base Condition for exiting the function */
    if (idx >= numsSize) {
        return max_cnt;
    }
    /* prevChosen: It means that if previous house was chosen for robbing or not */
    /* If prevChosen is False: then the robber has 2 choices either to rob the house or
     *  leave it, that's the reason for prevChosen false case we go over both cases 
     *
     * if prevChosen is true : it means we only have one choice, not to rob the current house
     */
    if (!prevChosen) {
        ret1 = rob_helper_func(nums, numsSize, max_cnt + nums[idx], idx + 1, true);
    }

    ret2 = rob_helper_func(nums, numsSize, max_cnt, idx + 1, false);

    /* Well !! it's time to find out the maximum amount robbed so far from both the recursive tree
     * section output */
    return max(ret1, ret2);
}

/* The first version of the program which uses recursive function to find the max amount
 * which can be robbed by going over the houses.
 * 
 **/
int rob_houses_version_1(int* nums, int numsSize){
    
    /* Validations */
    if (nums == NULL || numsSize == 0) {
        printf("The input array is NULL. Cannot proceed further\n");
        return 0;
    }
    return rob_helper_func(nums, numsSize, 0, 0, false);
    
}
/* Solution 2 and 3 are dynamic programming paradigm solutions */
/* The second version of the program which uses two extra variables to find the max amount
 * which can be robbed by going over the houses.
 *
 *  Time Complexity : O(n)
 *  Space Complexity : O(k) where k = 3 ,extra variables 
 **/
int rob_houses_version_2(int* nums, int numsSize) {

    int idx = 0;
    /* prev1: total money so far at 1 index less than the current one */
    /* prev2: total money so far at 2 index less than the current one */
    int prev1 = 0 , prev2 = 0;
    /* The  final sum of money will be stored here */
    int curr_sum = 0;

    /* Validations */
    if (nums == NULL || numsSize == 0) {
        printf("The input array is NULL. Cannot proceed further\n");
        return 0;
    }
    
    /* Go over all the elements */
    for (idx = 0; idx < (numsSize); idx++) {
        /* Update the prev2 and prev1 based on the calculations */
        prev2 = prev1;
        prev1 = curr_sum;
        /* 2 choices at every index 
         * 1. Don't rob the house : so prev1 is still the current sum
         * 2. Rob the house : so prev2 + current idx value will be total sum
         *
         */
        curr_sum = max((nums[idx] + prev2), prev1);
    }
    return curr_sum; 
}

/* The third version of the program which uses two extra array to find the max amount
 * which can be robbed by going over the houses.
 *
 *  Time Complexity : O(n)
 *  Space Complexity : O(n + 2)
 **/

int rob_houses_version_3(int* nums, int numsSize) {

    int idx = 0, *sum_arr = NULL;
    int final_sum = 0;
    if (nums == NULL || numsSize == 0) {
        printf("The input array is NULL. Cannot proceed further\n");
        return 0;
    }
    /* Allocation */
    sum_arr = (int *)calloc(numsSize + 2, sizeof(int));
    if (!sum_arr) {
        printf("Memory allocation failed \n");
        return -1;
    }
    /* Start from index 2 to accomodate the extra space array taken to store the
     * current sum of money at each index */
    for (idx = 2; idx < (numsSize + 2); idx++) {
        /* 2 choices at every index 
         * 1. Don't rob the house : so sum_arr[idx - 1] is still the current sum
         * 2. Rob the house : so sum_arr[idx - 2] + current idx (nums[idx - 2])value will be total sum
         *
         */
        sum_arr[idx] = max((nums[idx - 2] + sum_arr[idx - 2]), sum_arr[idx - 1]);
    }
    /* Answer is in the last index */
    final_sum = sum_arr[idx - 1];
    /* Free the memory allocation */
    free(sum_arr);

    return final_sum; 
}

int main(int argc, char *argv[]) {
    int *num_p = NULL;
    int idx = 0;
    if (argc < 2) {
        printf("Usage: ./a.out <num1> ... <num n>\n");
        exit(1);
    }
    num_p = (int *)malloc((argc - 1)*sizeof(int));
    if (num_p == NULL) {
        printf("Memory allocation failed \n");
        return -1;
    }
    /* Dont want to change the function, so copying the input to int array */
    for (idx = 1; idx <= (argc - 1); idx++) {
        num_p[idx - 1] = atoi(argv[idx]);
    }

    /* Execute the dynamic programming solution for best results */
    printf("Max Money which can be robbed : %d\n", rob_houses_version_3(num_p, argc - 1));
    free(num_p);
    return 0;
}
