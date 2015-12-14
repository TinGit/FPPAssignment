package w3LabHomeworkLesson12;

import java.util.InputMismatchException;
import java.util.Scanner;

class MyException  extends Exception 
{
	MyException()
	{
		System.out.println("Mark should be in the range of 0 to 100");
	}
}

public class MarkRange {

	public static void main(String[] args) throws Throwable 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Mark");
		try
		{
			int mark = in.nextInt();
		    if(mark<0 || mark >100)
		    	throw new MyException();
			
		    System.out.println();
			System.out.println("Mark entered successfully");
		}catch(InputMismatchException e)
		{
			System.out.println("Enter number only.");
		}
	}
}
