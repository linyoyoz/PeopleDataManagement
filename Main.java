import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Security security = new Security(); 
		security.securityCheck();
		Command CommandSystem = new Command();
		String state = "mode";
		String target = null;
		String target2 = null;

		Menu mode = null;//畫面
		
		MainMenu mainmode = new MainMenu();
		ManagementMenu managementmode = new ManagementMenu();
		UserMenu usermode = new UserMenu();

		int window = 0;
		int wait=1;

		StringTokenizer c;
		
		mode = mainmode;
		while(!(state.equals("quit")))
		{
			//取得目前狀態字串
			state=mode.perform(wait);
			target=null;
			target2 = null;

			//分割字串
			c = new StringTokenizer(state," ");
			if(c.hasMoreTokens())
				state = c.nextToken();
			else
				continue;
			if(c.hasMoreTokens())
				target = c.nextToken();
			if(c.hasMoreTokens())
				target2 = c.nextToken();
			
				

			//System.out.println(state);
			//System.out.println(target);
			//System.out.println(target2);
			//判斷狀態的命令
			if(state.equals("manage")&&window == 0)
			{
				mode = managementmode;
				window = 2;
				wait = 0;
			}
			else if(state.equals("back")&& window != 0)
			{
				mode = mainmode;
				window = 0;
				wait = 0;
			}
			else if(state.equals("user")&&window == 0)
			{
				mode = usermode;
				window = 1;
				wait = 0;
			}
			else if(state.equals("quit")&&window == 0)
			{
				wait = 0;
				break;
			}
			else
			{
				wait = 1;
				CommandSystem.Run(state,target,target2,window);
			}
			
		}
	}
}