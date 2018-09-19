import java.util.*;
import java.io.*;

public class Data
{
	private int id;
	private String name;
	private int birthday;
 	private String email;
	private int phone;
	private Data next;
	private String category;
	Data(int d,String n,int b,int p,String e,String c)
	{
		setAll( d, n, b,p ,e,c);
	}
	public void setAll(int d,String n,int b,int p,String e,String c)
	{
		id=d;
		name=n;
		birthday=b;
 		email=e;
		phone=p;
		category = c;
	}
	void Display(int c)
	{
		if((c&(1<<0))==(1<<0))
			DisplayString(8,this.name);
		if((c&(1<<1))==(1<<1))
			System.out.printf("%04d   ",birthday);
		if((c&(1<<2))==(1<<2))
			System.out.printf("%010d   ",phone);
		if((c&(1<<3))==(1<<3))
			DisplayString(35,this.email);
		System.out.printf("%s",category);
		System.out.println();
	}
	void DisplayString(int m,String c)
	{
		System.out.printf("%s",c);
		for(int i=c.length();i<m;i++)
			System.out.printf(" ");
	}
	Data getNext()
	{
		return this.next;
	}
	void setNext(Data d)
	{
		this.next=d;
	}
	String getName()
	{
		return name;
	}
	int getBirthday()
	{
		return birthday;
	}
	int getPhone()
	{
		return phone;
	}
	String getEmail()
	{
		return email;
	}
	String getCategory()
	{
		return category;
	}
}