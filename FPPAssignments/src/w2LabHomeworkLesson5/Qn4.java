package w2LabHomeworkLesson5;

import java.time.LocalDate;
import java.util.Scanner;

public class Qn4 {

}

//Employee Interface
interface Employee {
	int baseSalary =10;
	int bonus=2;
	int extraHour =15;
	
	String getEmployeeInfo();
	
	default void getEmployeeDetails(){
		System.out.println(getEmployeeInfo());
	}
	double calculateSalary();
	
}

//Manager
class Manager implements Employee{
	int noHours;
	int noYears;
	int extraHours;
	
	String employeeName;
	int employeeId;
	String ssn;
	LocalDate dateOfBirth;
	String address;
	
	Manager(String employeeName,int employeeId,String ssn,LocalDate dateOfBirth,String address)
	{
		this.employeeName= employeeName;
		this.employeeId= employeeId;
		this.ssn= ssn;
		this.dateOfBirth= dateOfBirth;
		this.address= address;
	}
	
	@Override
	public double calculateSalary() {
		double salary =baseSalary*2*noHours;
		if(noHours>150)
		{
			extraHours = (noHours-150);
			salary = salary +(extraHours*extraHour);
		}
		return salary;
	}


	@Override
	public String getEmployeeInfo() {
		// TODO Auto-generated method stub
		String newline = System.getProperty("line.separator");
		return "Employee name is "+employeeName+newline+"Employee Id is "+employeeId+newline+"Employee SSN is "+ssn+newline+
				"Employee Date of Birth is: "+dateOfBirth+newline+"Employee address is "+address;
		
	}

}

//Secretary Class
class Secretary4 implements Employee{
	int noHours;
	int noYears;
	
	String employeeName;
	int employeeId;
	String ssn;
	LocalDate dateOfBirth;
	String address;
	
	Secretary4(String employeeName,int employeeId,String ssn,LocalDate dateOfBirth,String address)
	{
		this.employeeName= employeeName;
		this.employeeId= employeeId;
		this.ssn= ssn;
		this.dateOfBirth= dateOfBirth;
		this.address= address;
	}
	
	@Override
	public double calculateSalary() {
		double salary = noHours*baseSalary;
		if(noYears>5)
			salary = salary+(salary*0.1);
		if(noHours>150)
			salary = salary+(bonus*(noHours-150));
		return salary;
	}

	@Override
	public String getEmployeeInfo() {
		// TODO Auto-generated method stub
		String newline = System.getProperty("line.separator");
		return "Employee name is "+employeeName+newline+"Employee Id is "+employeeId+newline+"Employee SSN is "+ssn+newline+
				"Employee Date of Birth is: "+dateOfBirth+newline+"Employee address is "+address;
		
	}

}


//Main Class
class Main4
{
	public static void main(String[] args)
	{
		Manager m= new Manager("Tinbit Kassahun",98881,"SN1345",LocalDate.of(1985,10,2),"Fairfield Iowa");
		Secretary4 s = new Secretary4("Jhon Smith",1256,"SN45645",LocalDate.of(1988,03,24),"Chicago");
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of Hours the secretary worked: ");
		s.noHours = in.nextInt();
		System.out.print("Enter no of Years the secretary worked: ");
		s.noYears = in.nextInt();
		
		System.out.println();
		System.out.print("Enter number of Hours the manager worked: ");
		m.noHours = in.nextInt();
		System.out.print("Enter no of Years the manager worked: ");
		m.noYears = in.nextInt();
		
		System.out.println();
		System.out.println("The monthly salary of manager is: "+m.calculateSalary());
		System.out.println("The monthly salary of secretary is: "+s.calculateSalary());
		
		System.out.println();
		System.out.println("Manager Employee Information:");
		m.getEmployeeDetails();
		
		System.out.println();
		System.out.println("Secretary Employee Information:");
		s.getEmployeeDetails();
		
	}
}