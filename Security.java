import java.util.*;
public class Security
{
	Scanner s;
	Security()
	{
		s = new Scanner(System.in);
	}
	boolean securityInput()
	{
		System.out.print("�п�J�b��:");
		String a=s.next();
		if(!a.equals("cis"))
			return false;
		System.out.print("�п�J�K�X:");
		a=s.next();
		if(!a.equals("1234"))
			return false;
		return true;
	}
	void securityCheck()
	{
		while(!securityInput())
		{
			System.out.println("��J���b���K�X���~!");
		}
		System.out.println("�n�J���\!");
	}
}