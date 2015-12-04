package w2LabHomeworkLesson5;


public class Qn3 {

}

//Computer Class
abstract class Computer3 {
	String manufacturer;
	String processor;
	int ramSize;
	int diskSize;
	double processorSpeed;
	
	Computer3(String manufacturer, String processor, int ramsize,int disksize, double processorSpeed)
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

	abstract double costProduct();

}

//NoteBook Class
class NoteBook3 extends Computer3 {
	double height;
	double width;
	double weight;
	
	NoteBook3(double height, double width, double weight,String manufacturer, String processor, int ramsize,int disksize, double processorSpeed)
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
	double costProduct() {
		// TODO Auto-generated method stub
		return 1000.0;
	}

}

//Main class
class Main3 {

	public static void main(String[] args)
	{
		NoteBook3 obj = new NoteBook3(2.2, 5.0, 10.0,"Toshiba", "Intel", 8,750, 2.1);
		
		System.out.println("Ram size: "+obj.getRamSize());
		System.out.println("Disk size: "+obj.getDiskSize());
		System.out.println("Processor speed: "+obj.getProcessorSpeed());
		
		System.out.println("Power of computer: "+obj.computePower());
		System.out.println("Screen size :"+obj.screensize());
		
		System.out.println("Cost of Notebook is: "+obj.costProduct());
	}
}
