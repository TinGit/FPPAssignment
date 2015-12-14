package w3LabHomeworkLesson12;

public class Division {

	public static void divide(int[] numer, int[] denom)
	{
		for(int i=0;i<numer.length;i++)
		{
			try
			{
				System.out.println("Division result "+numer[i]/denom[i]);
			}catch(ArithmeticException e)
			{
				System.out.println("Division by zero is not allowed.");
			}
			catch(ArrayIndexOutOfBoundsException ex)
			{
				System.out.println("Array index is out of bound.");
			}
		}
	}
	
	public static void main(String[] args)
	{
		int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };

		divide(numer,denom);	
	}
}
