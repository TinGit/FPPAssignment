package w2LabHomeworkLesson7;

public class MyTable {
	private Entry[] entries = new Entry[26];
	public static void main(String[] args)
	{
		MyTable t = new MyTable();
		t.add('a',"Andrew");
		t.add('b',"Billy");
		t.add('c',"Charlie");
		
		System.out.println();
		System.out.println(t);
		
		
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
