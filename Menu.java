import java.util.*;
public abstract class Menu
{
	Scanner s;
	Menu()
	{
		s = new Scanner(System.in);
	}
	public abstract void output();
	public String input()
	{
		String c;
		c=s.nextLine();
		return c;
	}
	public void empty(int i)
	{
		while(i>0)
		{
			System.out.println();
			i--;
		}
	}
	public String perform(int wait)
	{
		if(wait==1)
		{
			System.out.print("輸入任意鍵以繼續:");
			input();
		}
		empty(10);
		output();
		empty(1);
		return input();
	}
}