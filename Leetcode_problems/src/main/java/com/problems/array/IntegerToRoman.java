package com.problems.array;

/*

1.Leet code Problem Number :- 12

2.Leet code Problem Name :- Integer To Roman

S   V    S -> Symbol, V-> Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000

* if the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted
  from the input, append that symbol to the result, subtract its value, 
  and convert the remainder to a Roman numeral.
  
* If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted 
 from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X):
  IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) 
  and 900 (CM).
  
* Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of
 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. 
  If you need to append a symbol 4 times use the subtractive form.
  
Example 1:
Input: num = 3749
Output: "MMMDCCXLIX"

Explanation:
3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places


Complexity :-

1. Time Complexity :- O(1)
2. Space Complexity :- O(1)

 */

public class IntegerToRoman 
{
	public static String intToRoman(int num)
	{
        // Define Roman numeral symbols and their corresponding values
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        
        StringBuilder roman=new StringBuilder();
        
        for(int i=0;i<values.length;i++)
        {
        	// Append the symbol while the value fits into num
        	while(num>=values[i])
        	{
        		// Add the corresponding Roman symbol
        		roman.append(symbols[i]);
        		
        		// Subtract the value from the number
        		num-=values[i];
        	}
        }
     // Return the final Roman numeral
        return roman.toString();
	}
	
	public static void main(String args[])
	{
		int num=3749;
		
		String result=intToRoman(num);
		
		System.out.println("The Roman Value of the Given Integer Value is: "+result);
	}

}
