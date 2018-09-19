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
		System.out.print("請輸入帳號:");
		String a=s.next();
		if(!a.equals("cis"))
			return false;
		System.out.print("請輸入密碼:");
		a=s.next();
		if(!a.equals("1234"))
			return false;
		return true;
	}
	void securityCheck()
	{
		while(!securityInput())
		{
			System.out.println("輸入的帳號密碼有誤!");
		}
		System.out.println("登入成功!");
	}
}