package w3LabHomeworkLesson11;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


class Course{
	String c_name;
	String[] faculty;

	Course(String cname,int max)
	{
		this.c_name = cname;
		faculty = new String[max];
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String[] getFaculty() {
		return faculty;
	}

	public void setFaculty(String[] faculty) {
		this.faculty = faculty;
	}	
	
	public String toString()
	{
		String[] fa = getFaculty();
		String str = "Course Name: "+getC_name()+", Faculty: ";
		for(int i=0;i<fa.length;i++)
		{	
			if(i==fa.length-1)
				str = str+fa[i];
			else
				str = str+fa[i]+", ";
		}
		return str;
	}
	
}

public class CourseOperation
{
	HashMap<String,Course> courseMap = new HashMap<String,Course>();
	
	public boolean find(String c_id)
	{
		if(courseMap.get(c_id) !=null)
			return true;
		else
			return false;
	}
	
	public int sie()
	{
		return courseMap.size();
	}
	
	public String[] retrieveKeys(HashMap<String,Course> map)
	{
		 Set<String> keyList = map.keySet();
		 String[] strKey = new String[keyList.size()];
		 Iterator it=keyList.iterator();
		 int i=0;
		 while(it.hasNext())
		 {
			 strKey[i]= (String) it.next();
			 i++;
		 }
		 return strKey;
	}
	
	public Course[] retrieveValues(HashMap<String,Course> map)
	{
		Collection<Course> courseCollection = map.values();
		Course[] courseArr = new Course[courseCollection.size()];
		Iterator it = courseCollection.iterator();
		int i=0;
		while(it.hasNext())
		{
			courseArr[i]=(Course) it.next();
			i++;
		}
		return courseArr;
	}
	
	public static void main(String[] args) {
		CourseOperation obj = new CourseOperation();
		
		Course c1 = new Course("FPP",3);
		c1.faculty[0]="Renuka";
		c1.faculty[1]="Joe Lermon";
		c1.faculty[2]="paul";
		
		Course c2 = new Course("MPP",2);
		c2.faculty[0]="Jhon Smith";
		c2.faculty[1]="Victor";
		
		Course c3 = new Course("EA",1);
		c3.faculty[0]="Gebre";
		
		
		obj.courseMap.put("CS390",c1);
		obj.courseMap.put("CS411",c2);
		obj.courseMap.put("CS590",c3);
		
		
		System.out.println("Is course id CS411 in the list? "+obj.find("CS411"));
		System.out.println("Is course id CS400 in the list? "+obj.find("CS400"));
		
		System.out.println();
		System.out.println("List of keys:");
		String[] keys = obj.retrieveKeys(obj.courseMap);
		for(String k:keys){
			System.out.println(k);
		}
		
		System.out.println();
		System.out.println("List of values");
		Course[] values = obj.retrieveValues(obj.courseMap);
		for(Course c: values)
		{
			System.out.println(c);
		}
		
		System.out.println();
		System.out.println("Size of the list:"+obj.courseMap.size());
		
		System.out.println();
		System.out.println("All collections in the HashMap");
		
		for(HashMap.Entry<String, Course> entry: obj.courseMap.entrySet())
		{
			System.out.println("CourseID:"+entry.getKey()+"===>"+entry.getValue());
		}
	}	
}
