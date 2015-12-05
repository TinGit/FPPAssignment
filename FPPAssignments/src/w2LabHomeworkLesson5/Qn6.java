package w2LabHomeworkLesson5;

public class Qn6 {

}
//Computer Class
class Computer6 {
	String manufacturer;
	String processor;
	int ramSize;
	int diskSize;
	double processorSpeed;
	
	Computer6(String manufacturer, String processor, int ramsize,int disksize, double processorSpeed)
	{
		this.manufacturer = manufacturer;
		this.processor = processor;
		this.ramSize = ramsize;
		this.diskSize = disksize;
		this.processorSpeed = processorSpeed;
	}
	
	public int getRamSize() {
		return ramSize;
	}

	public int getDiskSize() {
		return diskSize;
	}

	public double getProcessorSpeed() {
		return processorSpeed;
	}
	
	double computePower()
	{
		// return ramSize multiplied by processorSpeed
		return ramSize*processorSpeed;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		Computer6 c = (Computer6)obj;
		if(!c.manufacturer.equals(this.manufacturer))
			return false;
		if(!c.processor.equals(this.processor))
			return false;
		if(c.ramSize != this.ramSize)
			return false;
		if(c.diskSize != this.diskSize)
			return false;
		if(Double.doubleToLongBits(c.processorSpeed) != Double.doubleToLongBits(this.processorSpeed))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diskSize;
		result = prime * result+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result+ ((processor == null) ? 0 : processor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(processorSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ramSize;
		return result;
	}
}

//NoteBook Class
class NoteBook6 extends Computer6 implements Cloneable{
	double height;
	double width;
	double weight;
	
	NoteBook6(double height, double width, double weight,String manufacturer, String processor, int ramsize,int disksize, double processorSpeed)
	{
		super(manufacturer, processor,ramsize,disksize,processorSpeed);
		this.height = height;
		this.width = width;
		this.weight = weight;
	}
	double screensize()
	{
		// return height multiplied by width
		return height*width;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj==null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteBook6 nb = (NoteBook6) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(nb.height))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(nb.weight))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(nb.width))
			return false;
		return true;
	}

	protected Object clone() throws CloneNotSupportedException
	{
	    NoteBook6 clone=(NoteBook6)super.clone();
		return clone;	
	}
	
	public String toString()
	{
		return "Height is "+height+" width is "+width+" and weight is "+weight;
	}
}

//Main Class
class Main6 {

	public static void main(String[] args) throws CloneNotSupportedException
	{
		NoteBook6 obj = new NoteBook6(2.2, 5.0, 10.0,"Toshiba", "Intel", 8,750, 2.1);
		NoteBook6 obj3 = obj;
		Computer6 obj1 =new Computer6("Toshiba", "Intel", 8,750, 2.1);
		Computer6 obj2 =new Computer6("Toshiba", "Intel", 8,750, 2.1); 
		
	    if(obj1.equals(obj2))
	    	System.out.println("Obj1 and Obj2 are equal");
	    
	    System.out.println("Obj1 hascode="+obj1.hashCode());
	    System.out.println("Obj2 hascode="+obj2.hashCode());
	    System.out.println();
	    
	    if(obj.equals(obj3))
	    	System.out.println("Obj and Obj3 are equal");
	    
	    System.out.println("Obj hascode="+obj.hashCode());
	    System.out.println("Obj3 hascode="+obj3.hashCode());
	    System.out.println();
	    
	    System.out.println("Obj original value: "+obj);
	    NoteBook6 objClone = (NoteBook6) obj.clone();
	    System.out.print("ObjClone after cloning from Obj: ");
	    System.out.println(objClone.toString());
	}
}
