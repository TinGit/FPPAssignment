package w3LabHomeworkLesson12;

import java.util.Scanner;

class BalanceException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BalanceException()
	{
		System.out.println("Balance can not reach below 100");
	}
	BalanceException(String ex)
	{
		System.out.println(ex);
	}
}

public class CustomerAccount {

	String cus_name;
	String acc_No;
	double balance;
	
	public void deposit(double amt) 
	{
		balance = balance +amt;
	}
    
	public void withdraw(double amt)
	{
		balance = balance-amt;
	}

	public static void main(String[] args) throws BalanceException
	{
		CustomerAccount obj = new CustomerAccount();
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter deposit amount: ");
		double amt = in.nextDouble();
		if(amt<100)
			throw new BalanceException();
		else
			obj.deposit(amt);
		
		System.out.println();
		System.out.print("Enter amount of money to withdraw: ");
		double withdraw = in.nextDouble();
		if(withdraw > obj.balance)
			throw new BalanceException("Amount of money to withdraw cannot exceed balance amount.");
		else if(obj.balance - withdraw <=100)
			throw new BalanceException();
		else
			obj.withdraw(withdraw);
			
	}
}
