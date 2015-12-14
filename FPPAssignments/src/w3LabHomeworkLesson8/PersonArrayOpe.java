package w3LabHomeworkLesson8;

class Person
{
	private String lastName;
	private String firstName;
	private int age;
	
	public Person(String last, String first, int a)
	{ // constructor to initialize the values
		this.lastName = last;
		this.firstName = first;
		this.age = a;
	}
	
	public void displayPerson() // Display fisrtName, lastName and age
	{
		System.out.println("First name: "+this.firstName);
		System.out.println("LastName: "+this.lastName);
		System.out.println("Age: "+this.age);
		System.out.println();
	}
	
	public String getLastName() // get only the last name
	{ 
		return this.lastName;
	}
} // end class Person

public class PersonArrayOpe
{
	private Person[] a; // reference to array
	private int nElems = 3; // number of data items
	private int size;

	public PersonArrayOpe(int max) // constructor to initialize person array with size max and nElems;
	{
		a=new Person[max];
		size = nElems;
	}

	public Person find(String searchName) // Pass Lastname as an argument
	{ 
		for(Person p:a)
		{
			if(p.getLastName().equals(searchName))
				return p;
		}
		return null;
	} 
	
	public void insert(String last, String first, int age)// Insert at last
	{
		Person plast = new Person(last,first,age);
		int lastindex = a.length;
		resize();
		a[lastindex]=plast;
		size=size+1;
	}
	
	public boolean delete(String searchName) // Shift down the elements. Argument should be lastname
	{ 
		int deleteIndex =-1;
		for(int i=0;i<a.length;i++)
		{
			if(a[i].getLastName().equals(searchName))
			{
				deleteIndex =i;
				break;
			}
		}
		if(deleteIndex ==-1)
			return false;
		Person[] temp = new Person[a.length-1];
		System.arraycopy(a, 0, temp, 0, deleteIndex);
		System.arraycopy(a, deleteIndex+1, temp, deleteIndex, a.length-(deleteIndex+1));
		a=temp;
		size=size-1;
		return true;
	}
	
	public void displayAll() // displays array contents
	{
		System.out.println("All contents of the array are:-");
		for(int i=0;i<size;i++)
			a[i].displayPerson();
	}
	
	public int size() // Return the number of persons stored in the array
	{
		return size;
	}

	private void resize(){
		int len = a.length;
		int newlen = 2* len;
		Person[] temp = new Person[newlen];
		System.arraycopy(a, 0, temp, 0, len);
		a = temp;
	} 
	
	public static void main(String[] args)
	{
		PersonArrayOpe operation = new PersonArrayOpe(3);
		
		Person p = new Person("Hirutu","Tinbit",30);
		Person p1 = new Person("Smith","Jon",29);
		Person p2 = new Person("Mehari","Friat",29);
		
		operation.a[0]=p;
		operation.a[1]=p1;
		operation.a[2]=p2;
		
		operation.displayAll();
		
		System.out.println("Find Smith:");
		Person pfind = operation.find("Smith");
		pfind.displayPerson();
		
		//insertion
		operation.insert("Gebremelak","Gebre",28);
		
		System.out.println("After Inserting Gebre and Deleting Smith");
		operation.delete("Smith");
		
		operation.displayAll();
	}
}



