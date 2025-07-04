package com.problems.array;

/*

Leet Code Code Problem Number: 88

Leet Code Code Problem Name: Merge Sorted Array

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Complexties :-

1. Time Complexity :- O(m + n)
2. Space Complexity :- O(1)

 */

public class Merge_Sorted_Array
{
public static void mergeArray(int nums1[],int m,int nums2[],int n)
{
	//Last index in nums1
	int i=m-1;
	
	// Last index in nums2
	int j=n-1;
	
	//Last index of the merged Array
	int k=m+n-1;
	
	// Merge nums2 into nums1 from the Last
	while(i>=0 && j>=0)
	{
		if(nums1[i]>nums2[j])
		{
			nums1[k--]=nums1[i--];
		}
		else
		{
			nums1[k--]=nums2[j--];
		}
	}
	
	// If any elements left in nums2 (nums1's are already in place)
	while(j>=0)
	{
		nums1[k--]=nums2[j--];
	}
}

public static void main(String args[])
{
	int nums1[]= {1,2,3,0,0,0};
	int nums2[]= {4,5,6};
	
	int m=3;
	int n=nums2.length;
	
	mergeArray(nums1,m,nums2,n);
	
	for(int num:nums1)
	{
		System.out.println(num);
	}
}

}
