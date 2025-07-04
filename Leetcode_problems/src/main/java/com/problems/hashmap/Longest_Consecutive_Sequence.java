package com.problems.hashmap;

/*

1. Leet Code Problem Number:- 128
2. Leet Code Problem Name:- Longest Consecutive Sequence

Given an unsorted array of integers nums, return the 
length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4

Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 
Complexity :-

1. Time Complexity	:- O(n)
2. Space Complexity	:- O(n)
 
 */
import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence 
{ 
    public static int longest_Sequence(int nums[]) 
    {
        // Edge case: if input array is null or empty, return 0
        if (nums == null || nums.length == 0) 
        {
            return 0;
        }

        // Add all numbers to a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) 
        {
            set.add(num);
        }

        int longest_Streak = 0;

        // Loop through each number in the set
        for (int num : set) 
        {
            // Only start counting if 'num - 1' is not in the set (start of a sequence)
            if (!set.contains(num - 1)) 
            {
                int currentNum = num;
                int currentStreak = 1;

                // Keep incrementing currentNum and count the streak
                while (set.contains(currentNum + 1)) 
                {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak found so far
                longest_Streak = Math.max(longest_Streak, currentStreak);
            }
        }

        return longest_Streak;
    }

    // Main method to test the function
    public static void main(String[] args) 
    {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
  
        System.out.println("Longest consecutive length  " + longest_Sequence(nums1));     
    }
}
