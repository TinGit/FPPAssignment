package w2LabHomeworkLesson5;

import java.time.LocalDate;
import java.util.Scanner;

public class Qn1 {

}

//DeptEmployee class
class DeptEmployee {

	String name;
	LocalDate hireDate;
	protected double salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	double computeSalary()
	{
		return salary;
	}
}

//Professor class
class Professor extends DeptEmployee {
	int numberOfPublications;
	
	Professor(String name,LocalDate hireDate,double salary,int n)
	{
		this.name=name;
		this.hireDate = hireDate;
		this.salary = salary;
		numberOfPublications = n;
	}
	
	public int getNumberOfPublications() {
		return numberOfPublications;
	}

	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}
		
}

//Secretary class
class Secretary extends DeptEmployee {
	double overtimeHours;

	Secretary(String name, LocalDate hireDate,double salary,double overTime)
	{
		this.name=name;
		this.hireDate = hireDate;
		this.salary = salary;
		overtimeHours = overTime;
	}
	public double getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	
	double computeSalary()
	{
		return salary +(12*overtimeHours);
	}
	
}

//Main class
class Main {

	public static void main(String[] args)
	{
		Professor prof1 = new Professor("Tinbit Kassahun", LocalDate.of(2012,10,2),4000,4);
		Professor prof2 = new Professor("Friat Mehari", LocalDate.of(2013,9,05),3000,6);
		Professor prof3 = new Professor("Gebremedhen Yebrehu", LocalDate.of(2012,10,2),6000,5);
		Secretary sec1 = new Secretary("Meron Abebe", LocalDate.of(2011,11,15),2000,5);
		Secretary sec2 = new Secretary("Jhon Smith", LocalDate.of(2015,1,1),1500,7);
		
		DeptEmployee[] dept = new DeptEmployee[5];
		dept[0]=prof1;
		dept[1]=prof2;
		dept[2]=prof3;
		dept[3]=sec1;
		dept[4]=sec2;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Do you want to know sum of all professors salary, sum of all secretary salary and all salaries in the department (Y/N):");
		char ch =in.nextLine().toLowerCase().charAt(0);
		if(ch=='y')
		{
			double profSalary=0,secSalary = 0,totalSalary;
			for(DeptEmployee d:dept)
			{
				if(d instanceof Secretary)
				{
					Secretary s = (Secretary) d;
					secSalary=secSalary+s.computeSalary();
				}
				else
					profSalary= profSalary+d.computeSalary();
			}
			totalSalary = profSalary + secSalary;
			
			System.out.println("Sum of all professors salary is = "+profSalary);
			System.out.println("Sum of all secretary salary is = "+secSalary);
			System.out.println("Sum of total salary in the department is = "+totalSalary);
		}
		
	}
}
