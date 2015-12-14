package w3LabHomeworkLesson9;


class Queue
{
	int data;
	Queue next;
	
	Queue(int data)
	{
		this.data =data;
	}
}
public class QueueArray {

	private Queue[] q;
	int nElems;
	
	QueueArray(int size)
	{
		q = new Queue[size];
	}
	
	public void add(int data)
	{
		Queue newQ = new Queue(data);
		if(nElems==0)
		{
			q[0] = newQ;
			nElems++;
		}
		else
		{
			if(nElems>=q.length)
			{
				resize();
				q[nElems]=newQ;
			}
			else
				q[nElems]=newQ;
			nElems++;
		}
	}
	
	public void resize()
	{
		int len = q.length;
		int newlen = 2* len;
		Queue[] temp = new Queue[newlen];
		System.arraycopy(q, 0, temp, 0, len);
		q = temp;
	}
	
	public void remove()//removing element at the front of the queue
	{
		if(q.length!=0)
		{
			Queue[] temp = new Queue[q.length];
			System.arraycopy(q, 1, temp, 0, q.length-1);
			q=temp;
			nElems--;
		}
	}
	
	public Queue peek()
	{
		if(q.length!=0)
			return q[0];
		else
			return null;
	}
	
	public int size()
	{
		return q.length;
	}
	
	public boolean isEmpty()
	{
		if(q.length==0)
			return true;
		else
			return false;
	}
	
	public String toString() {
		String str =""; 
		for(int i=0;i<nElems;i++)
		{
			str=str+"==>"+q[i].data;
		}
		return str;
	}
	public static void main(String[] args)
	{
		QueueArray qa = new QueueArray(5);
		
		qa.add(3);
		qa.add(7);
		qa.add(5);
		qa.add(11);
		qa.add(10);
		qa.add(17);
		
		System.out.println(qa);
		
		System.out.println();
		System.out.println("After removing element from queue:");
		qa.remove();
		System.out.println(qa);
		
		System.out.println();
		System.out.println("Peeking from Queue returns:"+qa.peek().data);
		
		System.out.println();
		System.out.println("Size is:"+qa.size());
		System.out.println("No of elements:"+qa.nElems);
		
		System.out.println();
		System.out.println("Is queue empty? "+qa.isEmpty());
		
				
		
		
	}
}
