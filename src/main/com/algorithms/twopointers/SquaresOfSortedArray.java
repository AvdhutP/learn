package com.algorithms.twopointers;

/*Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] sortedSquares = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
           if(Math.abs(nums[start])>Math.abs(nums[end])) {
               sortedSquares[i] = nums[start] * nums[start];
               start++;
           }
           else {
               sortedSquares[i] = nums[end] * nums[end];
               end--;
           }

        }
        return  sortedSquares;
    }

}
