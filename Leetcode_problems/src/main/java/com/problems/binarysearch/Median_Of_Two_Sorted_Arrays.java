package com.problems.binarysearch;

/*

1. Leet Code Problem Number :- 4
2. Leet Code Problem Name :- Median of two sorted arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Complexity :-

1. Time Complexity :- O(Log(m+n))
2. Space Complexity :- O(1)

 */
public class Median_Of_Two_Sorted_Arrays 
{
    public static double medianArrays(int[] nums1, int[] nums2) 
    {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length) 
        {
            return medianArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) 
        {
            // Partition both arrays
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            // Edge values for out-of-bounds
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we found the correct partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                // Even total length
                if ((m + n) % 2 == 0) 
                {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } 
                // Odd total length
                else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } 
            // Move left in nums1
            else if (maxLeftX > minRightY) 
            {
                high = partitionX - 1;
            } 
            // Move right in nums1
            else 
            {
                low = partitionX + 1;
            }
        }

        // Input arrays are not valid (shouldn't happen if arrays are sorted)
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
    
    public static void main(String[] args) 
    {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println("Median is: " + medianArrays(nums1, nums2));
}
}
