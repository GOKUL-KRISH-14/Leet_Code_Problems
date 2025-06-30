package com.problems.string;

import java.util.HashMap;
import java.util.Map;

public class Find_The_First_Repeated_Non_Characters 
{
	private static Character non_Repeated_Characters(String names)
	{
		if(names==null || names.length()==0)
		{
		  return null;	
		}
		
		Map<Character,Integer> map=new HashMap<>();
		
		for(char ch:names.toCharArray())
		{
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
	
		for(char ch:names.toCharArray())
		{
			if(map.get(ch)==1)
			{
				return ch;
			}
		}
		
		return null;
	}
	
	public static void main(String args[])
	{
		String names="aabbc";
		
		Character result=non_Repeated_Characters(names);
		
		if(result!=null)
		{
			System.out.println("THE FIRST NON-REPEATED STRING IN THE CHARACTER IS: "+result);
		}
		else if(result==0)
		{
			System.out.println("ARRAY IS EMPTY");
		}
		else
		{
			System.out.println("NO NON-REPEATED NUMBER FOUND");
		}
		
	}

}
