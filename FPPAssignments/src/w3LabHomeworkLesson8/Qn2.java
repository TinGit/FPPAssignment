package w3LabHomeworkLesson8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Marketing implements Comparator<Marketing> {

	String employeename;
	String productname;
	double salesamount;
	
	Marketing(String employeename,String productname,double salesamount)
	{
		this.employeename = employeename;
		this.productname = productname;
		this.salesamount = salesamount;
	}

	public Marketing() {
		// TODO Auto-generated constructor stub
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public double getSalesamount() {
		return salesamount;
	}

	public void setSalesamount(double salesamount) {
		this.salesamount = salesamount;
	}

	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Marketing)) return false;
		Marketing e = (Marketing)ob;
		return e.employeename.equals(employeename) && e.productname.equals(productname) && Double.doubleToLongBits(e.salesamount) != Double
				.doubleToLongBits(salesamount);
	}
	
	public static final Comparator ENAME = new Comparator(){
		public int compare(Object o1, Object o2){

			String name1 = ((Marketing)o1).getEmployeename();
			String name2 = ((Marketing)o1).getEmployeename(); 
			return name1.compareTo(name2);
		}
	};
	
	public static final Comparator SALESAMT = new Comparator(){
		public int compare(Object o1, Object o2){
	
			Double amt1 =new Double(((Marketing)o1).getSalesamount());
			Double amt2 =new Double(((Marketing)o1).getSalesamount());
			return amt1.compareTo(amt2);
		}
	};/**/
	
	
	public String toString()
	{
		return "Employee Name is "+this.employeename+", product name is "+this.productname+" and sales amount is "+this.salesamount;
	}

	@Override
	public int compare(Marketing o1, Marketing o2) {
		// TODO Auto-generated method stub
		return o1.getEmployeename().compareTo(o2.getEmployeename());
	}
	
	/*@Override
	public int compare(Marketing o1, Marketing o2) {
		// TODO Auto-generated method stub
		return o1.getEmployeename().compareTo(o2.getEmployeename());
		//return 0;
	}*/
	
	
}

public class Qn2
{
	public static void main(String[] args)
	{
		ArrayList<Marketing> mkArray = new ArrayList<Marketing>();
		
		Marketing m = new Marketing("Tinbit","Laptop",2000.0);	
		Marketing m1 = new Marketing("Friat","Laptop",800.0);	
		Marketing m2 = new Marketing("Victor","Television",1000.0);	
		Marketing m3 = new Marketing("Gebre","Refrigerator",1500.0);
		
	    System.out.println("Adding to the ArrayList");
		mkArray.add(m);//adding to the array list
		mkArray.add(m1);
		mkArray.add(m2);
		mkArray.add(m3);
		System.out.println(mkArray);
		
		System.out.println();
		System.out.println("After removing index 1 from the ArrayList");
		mkArray.remove(1);//removing at index 1
		System.out.println(mkArray);
		
		System.out.println();
		Marketing m4 = new Marketing("Jenny","Furniture",500.0);
		System.out.println("After Setting index 0 of the ArrayList with different value");
		mkArray.set(0, m4);
		System.out.println(mkArray);
		
		System.out.println();
		//Before sort
		Marketing market = new Marketing();
		SalesAmtComparator sales = new SalesAmtComparator();
		//Sorting by employee name
		Collections.sort(mkArray, market);// Marketing.ENAME);
		
		System.out.println("After sort by Employee Name: ");
		for(int i=0; i<mkArray.size(); i++){
			Marketing mk = mkArray.get(i);
			System.out.println(mk.getEmployeename());
		}
		
		
		Collections.sort(mkArray,sales);//Marketing.SALESAMT);
		System.out.println("After sort by sales amount: ");
		for(int i=0; i<mkArray.size(); i++){
			Marketing mk = mkArray.get(i);
			System.out.println(mk.getSalesamount());
		}   
	
		System.out.println("Size of array is "+mkArray.size());
	//	System.out.println(market.compare(mkArray.get(1),mkArray.get(0)));
	}

}