package com.problems.array;

import java.util.HashSet;
import java.util.Set;

public class First_Repeating_Element 
{
	private static Integer first_Repeating_Element(int nums[])
	{
		Set<Integer> set=new HashSet<>();
		
		for(int num:nums)
		{
			if(set.contains(num))
			{
				return num;
			}
			set.add(num);
		}
		
		return null;
	}
	
	public static void main(String args[])
	{
		int nums[]= {1,2,3,1};
		
		Integer result=first_Repeating_Element(nums);
		
		System.out.println("\n THE FIRST REPEATING ELEMENT IN THE ARRAY IS: "+result);
	}

}
