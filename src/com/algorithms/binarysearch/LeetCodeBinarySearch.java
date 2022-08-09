package com.algorithms.binarysearch;

import java.util.Arrays;

public class LeetCodeBinarySearch {
    public int search(int[] nums, int target) {
        int index = 0;
        boolean exists = false;
        for ( int num:nums)
        {

            if (num == target){
                exists = true;
                break; }
            index++;
        }
        return exists==true?index:-1;
    }
}
