package w2LabHomeworkLesson5;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Qn5 {

}

//Shape class
abstract class Shape {
	String shapeName;
	
	String getShapeName()
	{
		shapeName = this.getClass().getSimpleName();
		return shapeName;
	}
	
	public abstract String toString();
	abstract double computeArea();
	abstract double computePerimeter();
	abstract void readShapeData();

}

//Circle class
class Circle extends Shape{

	double radius;
	
	@Override
	double computeArea() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat();	
		return Double.parseDouble(df.format(Math.PI*radius*radius));
	}

	@Override
	double computePerimeter() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat();	
		return Double.parseDouble(df.format(2*Math.PI*radius));
	}

	@Override
	void readShapeData() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter radius: ");
		radius = in.nextDouble();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String newline = System.getProperty("line.separator");
		String ret ="Radius of the circle is "+this.radius+"."+newline+"Its area is "+this.computeArea()+" and its perimeter is "+this.computePerimeter();
		return ret;
	}

}

//Rectangle Class
class Rectangle extends Shape{

	double width;
	double height;
	
	@Override
	double computeArea() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat();	
		return Double.parseDouble(df.format(width*height));
	}

	@Override
	double computePerimeter() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat();	
		return Double.parseDouble(df.format((2*width)+(2*height)));
	}

	@Override
	void readShapeData() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter width: ");
		width = in.nextDouble();
		System.out.print("Enter height: ");
		height = in.nextDouble();
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String newline = System.getProperty("line.separator");
		String ret = "Rectangle width is "+this.width+" long and its height is "+this.height+" long."+newline+"Its Area is "+this.computeArea()+" and its perimeter is "+this.computePerimeter();
		return ret;
	}

}

//Right Angle Triangle (RtTriangle Class)
class RtTriangle extends Shape {
	double base;
	double height;
	
	@Override
	double computeArea() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat();	
		return Double.parseDouble(df.format((base*height)/2));
	}

	@Override
	double computePerimeter() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat();	
		double perimeter = base+height+Math.sqrt(Math.pow(base, 2)+Math.pow(height, 2));
		return Double.parseDouble(df.format(perimeter));	
	}

	@Override
	void readShapeData() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base: ");
		base = in.nextDouble();
		System.out.print("Enter height: ");
		height = in.nextDouble();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String newline = System.getProperty("line.separator");
		String ret ="Triangle base is "+this.base+" and its height is "+this.height+newline+"Its area is "+this.computeArea()+" and its perimeter is "+this.computePerimeter();
	    return ret;
	}

}

//Main Class
class Main5 {

	public static Shape getShape() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What is the type of figure?");
		System.out.println("\t C-For Circle");
		System.out.println("\t R-For Rectangle");
		System.out.println("\t T-For Triangle");
		
		Shape obj = null;
		char ch = in.nextLine().toUpperCase().charAt(0);
		switch(ch)
		{
			case 'C':
				obj = new Circle();
				obj.readShapeData();
				break;
			case 'R':
				obj = new Rectangle();
				obj.readShapeData();
				break;
			case 'T':
				obj= new RtTriangle();
				obj.readShapeData();
				break;
			default:
				System.out.println("Type of figure you selected is not valid one.");
				break;
		}
		
		if(obj instanceof Rectangle)
			return (Rectangle) obj;
		else if(obj instanceof Circle)
			return (Circle) obj;
		else
			return (RtTriangle)obj;
	}
	
	public static void main(String[] args)
	{
		System.out.println(getShape());
	}
}

