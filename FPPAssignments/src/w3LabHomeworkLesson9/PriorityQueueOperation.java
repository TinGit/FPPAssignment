package w3LabHomeworkLesson9;


class PriorityQueue
{
	int data;
	PriorityQueue next;
	
	PriorityQueue(int data)
	{
		this.data = data;
		next =null;
	}
	
}

public class PriorityQueueOperation {
	PriorityQueue first;
	PriorityQueue last;
	
	//Add
	public void add(int data)
	{
		PriorityQueue newNode = new PriorityQueue(data);
		if(first==null) //empty queue
			first = newNode;
		else if(last == null) // there is only one element--(first)
		{
			if(first.data > data)
			{
				PriorityQueue temp = first;
				first = newNode;
				last = temp;
				first.next = temp;
			}
			else
			{
				last=newNode;
				first.next=newNode;
			}
		}
		else//if there is more than one element in the queue
		{
			if(data>last.data)//
			{
				PriorityQueue temp = last;
				last = newNode;
				temp.next = newNode;
			}
			else
			{
				PriorityQueue temp = first;
				PriorityQueue prevTemp=first;
				int count=0;
				while(temp!=null && data> temp.data)
				{
					prevTemp = temp;
					temp = temp.next;
					count++;
				}
				newNode.next = temp; 
				if(count == 0)
					first = newNode;
				if(count!=0)
					prevTemp.next = newNode;
				
			}
		}
	}
	
	
	//Remove
	/*public void remove()
	{
		PriorityQueue firstTemp = first;
		PriorityQueue nextTemp = firstTemp.next;
		while(firstTemp !=null && nextTemp !=null)
		{
			if(firstTemp.data> nextTemp.data)
				firstTemp = firstTemp.next;	
			else
				nextTemp = nextTemp.next;
		}
		System.out.println("Removed element is :"+firstTemp.data);
		firstTemp = null;
	}*/
	
	//check empty
	public boolean isEmpty()
	{
		if(first == null)
			return true;
		else
			return false;
	}

	//Size
	public int size()
	{
		PriorityQueue temp = first;
		int count=0;
		while(temp!=null)
		{
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	//Peek the front element in the queue
	public PriorityQueue peek()
	{
		return first;
	}
	
	public String toString()
	{
		String str =""; 
		PriorityQueue temp = first; 
		while (temp != null) {
			str = str + "==>[" + temp.data + "]";
			temp = temp.next;
		}
		str = str + "==>[" + "NULL" + "]";
		return str;
	}
	
	public static void main(String[] agrs)
	{
		System.out.println("Inserting data \"12 , 10, 9, 15 ,13 \"");
		PriorityQueueOperation obj = new PriorityQueueOperation();
		obj.add(12);
		obj.add(10);
		obj.add(9);
		obj.add(15);
		obj.add(13);
	
		System.out.println();
		System.out.println("The priority queue after insertion:");
		System.out.println(obj);
		
		System.out.println();
		System.out.println("Is queue empty? "+obj.isEmpty());
		
		System.out.println();
		System.out.println("Size is:"+obj.size());
		
		System.out.println();
		System.out.println("Peek element is:"+obj.peek().data);
	}
	
}
