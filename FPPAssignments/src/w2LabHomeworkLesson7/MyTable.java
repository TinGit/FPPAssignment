package w2LabHomeworkLesson7;

import java.util.Scanner;

public class MyTable {
	private Entry[] entries = new Entry[26];
	public static void main(String[] args)
	{
		MyTable t = new MyTable();
		t.add('a',"Andrew");
		t.add('b',"Billy");
		t.add('c',"Charlie");
		
		System.out.println();
		// To keep adding to Entry array
		Scanner in = new Scanner(System.in);
		char c='y',c1='y';
		do{	
		  
		  	System.out.print("Do you want to add to the Entry list? (Y/N)");
		  	c = in.nextLine().toLowerCase().charAt(0);
		  	if(c=='y')
		  	{
		  		System.out.println("Enter your string: ");
		  		String str = in.nextLine();
		  		System.out.println("Enter at what character index you want to put it (like a,b,c etc): ");
		  		char ch = in.nextLine().charAt(0);
		  		t.add(ch,str);
		  		System.out.println();
		  	}
	  	}while(c=='y');
		
		//Displaying the whole entry
		System.out.println("Displaying the content of Entry array:");
		System.out.println(t);
		//To get String by char
		do{
			System.out.print("Do you want to retrieve string by char?(Y/N): ");
			c1 = in.nextLine().charAt(0);
			if(c1=='y')
			{
				System.out.println("Enter the character here: ");
				char ch = in.nextLine().charAt(0);
				String value = t.get(ch);
				System.out.println(value);
			}
		}while(c1=='y');
	}
	//returns the String that is matched with char c in the table
	public String get(char c){
		int index = (int)c;
		if(entries[index-97] != null)
			return entries[index-97].name;
		else
			return null;
	}
	//adds to the table a pair (c, s) so that s can be looked up using c 
	public void add(char c, String s) {
		int asciVal = (int)c;
		entries[asciVal-97] = new Entry(s,c);
		System.out.println(entries[asciVal-97]);
	}
	//returns a String consisting of nicely formatted display
	//of the contents of the table
	public String toString() {
		String val="";
		String newline = System.getProperty("line.separator");
		for(int i=0;i<26;i++)
		{
			if(entries[i]!=null)
				val=val+entries[i].ch+"->"+entries[i].name+newline;
		}
		return val;
	}
	
	
	private class Entry {
		String name;
		char ch;
		Entry(String str, char ch){
			name=str;
			this.ch = ch;
		}
		//returns a String of the form "ch->str" 
		public String toString() {
		    String val = this.ch+"->"+this.name;
			return val;
		}
	}


}
