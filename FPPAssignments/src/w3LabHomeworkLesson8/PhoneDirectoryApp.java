package w3LabHomeworkLesson8;


class Directory {
	String name;
	long pno; // Phone number
	Directory next;

	public Directory(String name, long pno) { // Initialize values
		this.name=name;
		this.pno = pno;
		this.next = null;
	}

	// -------------------------------------------------------------
	public void displayDirectory() // display values of single element
	{
		System.out.println("Name:-"+name+",PhoneNo:-"+pno);
	}
	public String toString()
	{
		return "Name:-"+name+",PhoneNo:-"+pno;
	}
}

class DirectoryOpr {
	private Directory first; // ref to first Directory
	private Directory last; // ref to last Directory


	public DirectoryOpr() // constructor
	{
		first=null;
		last=null;
	}

	public boolean isEmpty() // true if no Directory in your list
	{
		if(first==null)
			return true;
		else
			return false;
	}

	public void insertFirst(String name, long pno) // insert at front of list
	{
		Directory front = new Directory(name,pno);
		if(first==null)
			first = front;
		else
		{
			front.next=first;
			first = front;
		}
	}


	public void insertLast(String name, long pno) // insert at end of list
	{
		Directory lastNode = new Directory(name,pno);
		if(first==null)
		{
			first=lastNode;
		}
		else
		{
			Directory temp = first;
			while (temp.next != null)
				temp = temp.next;
			
			temp.next = lastNode;
		}
	}


	public Directory deleteFirst() // delete first Directory
	{		
		if(first == null)
			return null;
		else if(first.next ==null)//only one element in the linked list
		{
			Directory temp = first;
			first=null;
			return temp;
		}
		else
		{
			Directory temp = first.next;
			first.next =null;
			first=temp;
			return first;
		}
	}

	public int size() {
		int count=0;
		if(first == null)
			return count;
		else
		{
			count++;
			Directory temp=first.next;
			while(temp !=null)
			{
				count++;
				temp = temp.next;
			}
		}
		return count;
	}

	public void displayList() {
		String str =""; 
		Directory temp = first; //findLast();
		while (temp != null) {
			str = str + "==>[" + temp.toString() + "]";
			temp = temp.next;
		}
		str = str + "==>[" + "NULL" + "]";
		System.out.println(str);
	}

	public Directory find(String key)      // find link with given key
    {
		if(first == null)
			return null;
		else
		{
			Directory temp = first;
			while(temp != null)
			{
				if(temp.name.equals(key))
					return temp;
				else
					temp=temp.next;
			}
				
			return null;
		}
    }
}
 

public class PhoneDirectoryApp
{
	public static void main(String[] args)
	{
		DirectoryOpr obj = new DirectoryOpr();
		System.out.println("Is List empty--"+obj.isEmpty());
		
		obj.insertFirst("Tinbit Kassahun", 911669078);
		obj.displayList();
		
		obj.insertLast("Gebre", 938643620);
		obj.displayList();
		
		System.out.println();
		System.out.println("Inserting at last");
		obj.insertLast("Selam",913335616);
		obj.displayList();
		
		System.out.println();
		System.out.println("Inserting at first");
		obj.insertFirst("Teddy",913535676);
		obj.displayList();
		
		System.out.println();
		System.out.println("Deleting first element");
		obj.deleteFirst();
		obj.displayList();
		
		System.out.println("Found object is ["+obj.find("Gebre")+"]");
		
		System.out.println("Size of list is= "+obj.size());
		obj.displayList();
	}
	
}

