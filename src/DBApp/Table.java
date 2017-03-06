package DBApp;

//import java.io.File;
//import java.io.FileOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class Table {
	
	int numPages;
	String name;
	String [] colNames;
	String [] colTypes;
	Page last;
	String path = "C:\\Databases";
	String path1 = "C:\\Databases\\Table_";
	boolean open;
		
	//First Step: Constructing a table - You should initialize the variables given above -
	public Table(String name, String [] colNames,String [] colTypes) throws IOException
	{
	
		this.name = name ;
		path1+=name+"\\";
		this.colNames = colNames;
		this.colTypes = colTypes ;
		File main = new File(path);
		File Dir  = new File(path+"\\Table_"+ name);
		if(!main.exists())
			main.mkdir();
		
		if(!Dir.exists())
		Dir.mkdir();
		else 
			System.out.println("Sorry Folder Already exists");
		numPages = 1;
	
		last = new Page(colNames.length,path1+numPages+".csv");
		FileWriter writer = new FileWriter(path1+numPages+".csv");
	}
		
	//Function1: A function that creates a "Tables" folder in which the pages of a table will be created 
	//and adds a page into that folder
	public void addPage() throws IOException // removed Page p 
	{
		numPages++;
		last = new Page(colNames.length,path1+numPages+".csv");
		FileWriter writer = new FileWriter(path1+numPages+".csv");
	
		// We could add header information in this method 
	}
	
	
	//Function2: A function that inserts a record of strings into the last page of the table if it is not full,
	//otherwise, it should add a new page into the folder and insert the record into it
	public int insert (String []record) throws ClassNotFoundException, IOException
	{        
		if(!last.insert(record))
		{
			addPage();
			last.insert(record);
		}
		
			
		return 1;
	}
		
	//Testing Your Code
	public static void main(String []args) throws IOException, ClassNotFoundException {
		
		String tName="Student";
		String [] tColNames={"ID","Name","GPA","Age","Year"};
		String [] tColTypes={"int","String","double","int","int"};			
		Table t = new Table(tName,tColNames,tColTypes);

		
		for(int i=0;i<300;i++)
		{
			String []st={""+i,"Name"+i,"0."+i,"20","3"};
			t.insert(st);
		}
		for(int i=0;i<300;i++)
		{
			String []st={""+(i+300),"Name"+(i+300),"0."+(i+300),"21","4"};
			t.insert(st);
		}
			
		for(int i=0;i<300;i++)
		{
			String []st={""+(i+600),"Name"+(i+600),"0."+(i+600),"21","3"};
			t.insert(st);
		}
			
		System.out.println(t);
		
	}
}