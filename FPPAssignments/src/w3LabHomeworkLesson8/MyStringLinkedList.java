package w3LabHomeworkLesson8;

public class MyStringLinkedList {

	Node header;

	MyStringLinkedList() {
		header = null;
	}

	public void addFront(String item) {
		if (header == null)
			header = new Node(null, item, null);
		else {
			Node n = new Node(null, item, header);
		    	header.previous = n;
		    	header = n;
		}
	}

// Implement the code

	public void addLast(String item) {
		Node last = findLast();
		Node newLastNode;
		if(last == null)
		{
			newLastNode = new Node(null,item,null);
		}
		else
		{
			newLastNode = new Node(last,item,null);
			last.next = newLastNode;
		}
	}


	// implement the code
	public void postAddNode(Node n, String value){
		Node newNode;
			if(n==null)
			{
				newNode = new Node(null,value,null);
			}
			else if(n.next==null)
			{
				newNode = new Node(n,value,null);
				n.next = newNode;
			}
			else
			{
				newNode = new Node(n,value,n.next);
				n.next.previous = newNode;
				n.next=newNode;
			}
									
	}
// implement the code

    public int Size(){
    	int count =0;
    	if (header == null)
   			return count;
   		else {
   				Node temp = header;
   				count++;
   				while (temp.next != null)
   				{
   					count++;
   					temp = temp.next;
   				}
   				return count;
   			}
       }

// implement code
    public boolean isEmpty()
    {
    	if(header==null)
    		return true;
    	else
    		return false;
    }  

    //get first object
    public Object getFirst(){
    		return header;
    }
      
    //get last object
    public Object getLast(){
    	return findLast();
    }
	
    //remove first element
    public void removeFirst(){
    	if(header !=null && header.next == null)
    	{
    		header = null;
    	}
    	else if(header !=null)
    	{
    		header.next.previous= null;
    		header =header.next;
    	}
    }
    
    //remove last element
    public void removeLast(){
    	Node last = findLast();
    	if(last!=null && last.previous==null)
    	{
    		last=null;
    	}
    	else if(last!=null)
    	{
    		last.previous.next = null;
    		last.previous=null;
    		last=null;
    	}
    }
    
	public void preAddNode(Node n, String value){
		Node newNode;
		if (n == null){
			//List is empty
			newNode = new Node(null, value, null);
		}
		else if (n.previous == null) {
			//n is the first node
			addFront(value);
		}
		else {
			newNode = new Node(n.previous, value, n);
			n.previous.next = newNode;
			n.previous = newNode;
		}	
					
	}
	
	public Node findLast() {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp.next != null)
				temp = temp.next;
			return temp;
		}
	}

	public Node findItem(String str) {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp != null)
				if (str.equals(temp.value))
					return temp;
				else
					temp = temp.next;
			return null;
		}
	}

	public void deleteNode(Node n) {
		if (header != null && n != null) {
			if (n.next == null && n.previous == null) {
				// only one node
				header = null;
				n = null;
				System.out.println("I am here 1");

			} else if (n.previous == null) {
				// remove first node
				n.next.previous = null;
				header = n.next;
				n = null;
				System.out.println("I am here 2");
			} else if (n.next == null) {
				// remove last node
				n.previous.next = null;
				n = null;
				System.out.println("I am here 3");
			} else {
				// general case
				n.next.previous = n.previous;
				n.previous.next = n.next;
				n = null;
				System.out.println("I am here 4");
			}

		}

	}
	
	public void deleteList(){
		Node tempOne = header;
		Node tempTwo = header;
		while (tempOne != null) {
			tempOne = tempOne.next;
			tempTwo = null;
			tempTwo = tempOne;
		}
		header = null;
	}

	public String toString() {
		String str =""; 
		Node temp = header;
		while (temp != null) {
			str = str + "-->[" + temp.value.toString() + "]";
			temp = temp.next;
		}
		str = str + "-->[" + "NULL" + "]";
		return str;
	}

	public void printReverse() {
		String str =""; 
		Node temp = findLast();
		while (temp != null) {
			str = str + "==>[" + temp.value.toString() + "]";
			temp = temp.previous;
		}
		str = str + "==>[" + "NULL" + "]";
		System.out.println(str);
	}
	

	public class Node {
		String value;
		Node next;
		Node previous;

		Node(Node previous, String value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return value;
		}
	}

	public static void main(String[] args) {
		MyStringLinkedList mySL = new MyStringLinkedList();

		mySL.addFront("Carrot Cake");
		mySL.addFront("Blueberry Muffin");
		mySL.addFront("Apple Pie");
		System.out.println(mySL);
		
	//adding at last
		mySL.addLast("Orange Juice");
		System.out.println(mySL);
		
		mySL.postAddNode(mySL.findItem("Carrot Cake"), "Danish Delight" );
		System.out.println(mySL);
		
		System.out.println("Size of linkedlist is: "+mySL.Size());
		
		System.out.println("Is linkedlist empty:"+mySL.isEmpty());
		
		System.out.println("First object is:"+mySL.getFirst());
		System.out.println("Last object is:"+mySL.getLast());
		
		System.out.println();
		
		
		System.out.println("After removing the last element:");
		mySL.removeLast();
		System.out.println(mySL);
		
		mySL.removeFirst();
				System.out.println("After removing the first element:");
				System.out.println(mySL);
	}
}
