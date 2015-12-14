package w3LabHomeworkLesson11;

import java.io.IOException;
import java.util.Scanner;


class PersonItem
{
	private String mail_id;  
	private String name;

	public PersonItem(String mailid, String v)  
	 { 
		mail_id = mailid;
	   name = v;
	 }

	public String getMail_id() {
		return mail_id;
	}

	public String getName() {
		return name;
	}	
}

class HashTable
{
	private PersonItem[] hashArray;    // array holds hash table
	private int arraySize;
	private PersonItem nonItem;        // for deleted items
//-------------------------------------------------------------
	public HashTable(int size)       // constructor
	{
		arraySize = size;
		hashArray = new PersonItem[arraySize];
		nonItem = null;   // deleted item key is -1
	}
//-------------------------------------------------------------
	public void displayTable()
	{
		System.out.println("Table: ");
		for(int j=0; j<arraySize; j++)
		{
			if(hashArray[j] != null)
				System.out.println("Index : " + j + " " + hashArray[j].getMail_id() + " " + hashArray[j].getName());
			else
				System.out.println("Index : " + j + " " + "**");
		}
		System.out.println("");
	}
//-------------------------------------------------------------
	public int hashFunc(String key)
	{
		char[] keychar = key.toCharArray();
		int len = keychar.length;
		double hascode=(double) 0;
		for(int i=0;i<len;i++)
		{
			hascode =  hascode+(int)keychar[i]*Math.pow(31, len-(i+1));
		}
		//System.out.println("hashcode of "+key+"====="+hascode);
		//System.out.println("hashcode of "+key+"====="+(int)hascode % arraySize);
		return (int) (hascode % arraySize);       // hash function
	}
//-------------------------------------------------------------
	public void insert(String key, String v) // insert a DataItem
	//(assumes table not full)
	{
		// extract key
		int hashVal = hashFunc(key);  // hash the key
                               // until empty cell 
		//an index have some data and not match with existing key, it find next vacant position 
		while(hashArray[hashVal] != null && hashArray[hashVal].getMail_id() != key) 
		{
			++hashVal;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
		}
		PersonItem obj = new PersonItem(key,v);
		hashArray[hashVal] = obj;    // insert item
	}  // end insert()
//-------------------------------------------------------------
	public PersonItem delete(String key)  // delete a DataItem
	{
		int hashVal = hashFunc(key);  // hash the key

		while(hashArray[hashVal] != null)  // until empty cell,
		{                               // found the key?
			if(hashArray[hashVal].getMail_id().equals(key))
			{
				PersonItem temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = nonItem;       // delete item
				return temp;                        // return item
			}
			++hashVal;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
		}
		return null;                  // can't find item
	}  // end delete()
//-------------------------------------------------------------
	public boolean find(String key)    // find item with key
	{
		int hashVal = hashFunc(key);  // hash the key

		while(hashArray[hashVal] != null)  // until empty cell,
		{                               // found the key?
			if(hashArray[hashVal].getMail_id().equals(key))
				return true;   // yes, return item
			++hashVal;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
		}
		return false;                  // can't find item
	}
//-------------------------------------------------------------
}  // end class HashTable

public class PersonItemApp {

	public static void main(String[] args) throws IOException
	{
		String aKey;
		String value;
                             
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of hash table: ");
		int size = in.nextInt();
                           
		HashTable theHashTable = new HashTable(size);

		theHashTable.insert("tinbit1","Tinbit Kassahun");
		theHashTable.insert("gcoolmoon","Gebre");
		theHashTable.insert("jhon","Jhon");
		theHashTable.insert("smith","Smith");
 
		while(true)   // interact with user
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = in.next().charAt(0); //Read a Char from the console
			switch(choice)
			{
				case 's':
					theHashTable.displayTable();
					break;
				case 'i':
					System.out.print("Enter key and value to insert: ");
					aKey = in.next();
					value = in.next();
					theHashTable.insert(aKey,value);
					break;
				case 'd':
					System.out.print("Enter key value to delete: ");
					aKey = in.next();
					theHashTable.delete(aKey);
					break;
				case 'f':
					System.out.print("Enter key value to find: ");
					aKey = in.next();
					System.out.println("Key Found status=" + theHashTable.find(aKey));
					break;
				default:
					System.out.print("Invalid entry\n");
			}  // end switch
		}  // end while
	}  // end main()
	
}
