package w3LabHomeworkLesson9;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

	boolean checkPalindrome(String str)
	{
		Stack<Character> chArray = new Stack<Character>();
		char[] input = str.toCharArray();
		//push
		for(char c : input)
			chArray.push(c);
		
		//pop
		char[] output=new char[input.length];
		for(int i=0;i<input.length;i++)
			output[i]=chArray.pop();
		
		//compare
		for(int i=0;i<input.length;i++)
		{
			if(input[i]!=output[i])
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		Palindrome obj = new Palindrome();
		System.out.print("Enter a string: ");
		Scanner in = new Scanner(System.in);
		boolean result = obj.checkPalindrome(in.nextLine());
		
		if(result)
			System.out.println("String is palindrome.");
		else
			System.out.println("String is not palindrome.");
	}
}
