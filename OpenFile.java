import java.util.*;
import java.io.*;

public class OpenFile
{
	Scanner s = null;
	OpenFile()
	{
		try
		{
			s =new Scanner(new FileInputStream("001.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
			System.exit(0);
		}
	}
	Scanner getScanner()
	{
		return s;	
	}
}