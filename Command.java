import java.util.*;
//切割字串指令並執行
public class Command
{
	//1為姓名 2為生日 4為電話 8為信箱 
	private int DisplayInformation;

	private DataList list;//建立一個資料串列

	Command()
	{
		DisplayInformation = 15;

		list = new DataList();
	}
	//判斷字串的命令
	public void Run(String state,String target,String target2,int window)
	{
		//display 全部		
		if(state.equals("lista")&&window==1)
		{
			//target 用來表示sort 
			if(target==null)
				list.Display(15);
			else
				list.Display(target,15);
		}
		else if(state.equals("list")&&window==1)
		{
			//target用來表示sort
			if(target==null)
				list.Display(DisplayInformation);
			else
				list.Display(target,DisplayInformation);
		}
		else if(state.equals("listc")&&window==1)
		{
			//target用來表示只要顯示的分類
			//target用來表示sort
			if(target==null)
			{
				System.out.println("缺少參數給與分類顯示");
				return;
			}
			if(target2==null)
			{
				list.Display(DisplayInformation,target);	
			}
			else
			{
				list.Display(target2,DisplayInformation,target);	
			}
		}
		else if(state.equals("modify")&&window==1)
		{
			if(target!=null&&target2!=null)
				list.Modify(target,target2);
			else
				System.out.println("缺少參數給與修改");
		}
		else if(state.equals("creat")&&window==1)
		{
			list.Insert();
		}
		else if(state.equals("delete")&&window==1)
		{
			if(target!=null&&target2!=null)
			{
				if(target.equals("phone"))
				{
					
					list.Delete(Integer.parseInt(target2));
				}
				else if(target.equals("name"))
				{
					list.Delete(target2);
				}
				else
				{
					System.out.println("無法指定屬性"+target+"去刪除");
				}
			}
			else
			{
				System.out.println("缺少參數給與刪除");	
			}
		}
		else if(state.equals("search")&&window==1)
		{
			if(target!=null&&target2!=null)
			{
				if(target.equals("phone"))
				{
					if(list.Search(Integer.parseInt(target2))==null)
						System.out.println("資料中沒有電話號碼"+target2);
				}
				else if(target.equals("name"))
				{
					if(list.Search(target2)==null)
						System.out.println("資料中沒有名字"+target2);
				}
				else
				{
					System.out.println("無法指定屬性"+target+"去搜尋");
				}
			}
			else
			{
				System.out.println("缺少參數給與搜尋");
			}
				
		}
		else if(state.equals("set")&&window==2)
		{
			if(target==null)
			{
				System.out.println("缺少參數給與設定");
				return;
			}
			setImformation(target);
		}
		else if(state.equals("write")&&window==2)
		{
			if(target==null)
			{
				list.write();
			}
			else
			{
				list.write(target);
			}
		}
		else if(!state.equals("quit"))
		{
			System.out.println("找不到命令"+state);
		}
	}
	public int toInteger(String s)
	{
		return 1;
	}
	public void setImformation(String target)
	{
		if(target.equals("name"))
			changeDisplay(0,target);
		else if(target.equals("birthday"))
			changeDisplay(1,target);
		else if(target.equals("phone"))
			changeDisplay(2,target);
		else if(target.equals("email"))
			changeDisplay(3,target);
		else if(target.equals("direction"))
			setDirection();
		else
			System.out.println("找不到屬性 "+target);
		
	}
	public void changeDisplay(int x,String target)
	{
		System.out.println((DisplayInformation&(1<<x))+" "+(1<<x));
		if((DisplayInformation&(1<<x))==(1<<x))
		{
			DisplayInformation-=(1<<x);
			System.out.println("關閉顯示屬性 "+target);
		}
		else
		{
			DisplayInformation+=(1<<x);
			System.out.println("開啟顯示屬性 "+target);
		}
	}
	public void setDirection()
	{
		list.setDirection();
	} 
}