import java.util.*;
//���Φr����O�ð���
public class Command
{
	//1���m�W 2���ͤ� 4���q�� 8���H�c 
	private int DisplayInformation;

	private DataList list;//�إߤ@�Ӹ�Ʀ�C

	Command()
	{
		DisplayInformation = 15;

		list = new DataList();
	}
	//�P�_�r�ꪺ�R�O
	public void Run(String state,String target,String target2,int window)
	{
		//display ����		
		if(state.equals("lista")&&window==1)
		{
			//target �ΨӪ��sort 
			if(target==null)
				list.Display(15);
			else
				list.Display(target,15);
		}
		else if(state.equals("list")&&window==1)
		{
			//target�ΨӪ��sort
			if(target==null)
				list.Display(DisplayInformation);
			else
				list.Display(target,DisplayInformation);
		}
		else if(state.equals("listc")&&window==1)
		{
			//target�ΨӪ�ܥu�n��ܪ�����
			//target�ΨӪ��sort
			if(target==null)
			{
				System.out.println("�ʤְѼƵ��P�������");
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
				System.out.println("�ʤְѼƵ��P�ק�");
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
					System.out.println("�L�k���w�ݩ�"+target+"�h�R��");
				}
			}
			else
			{
				System.out.println("�ʤְѼƵ��P�R��");	
			}
		}
		else if(state.equals("search")&&window==1)
		{
			if(target!=null&&target2!=null)
			{
				if(target.equals("phone"))
				{
					if(list.Search(Integer.parseInt(target2))==null)
						System.out.println("��Ƥ��S���q�ܸ��X"+target2);
				}
				else if(target.equals("name"))
				{
					if(list.Search(target2)==null)
						System.out.println("��Ƥ��S���W�r"+target2);
				}
				else
				{
					System.out.println("�L�k���w�ݩ�"+target+"�h�j�M");
				}
			}
			else
			{
				System.out.println("�ʤְѼƵ��P�j�M");
			}
				
		}
		else if(state.equals("set")&&window==2)
		{
			if(target==null)
			{
				System.out.println("�ʤְѼƵ��P�]�w");
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
			System.out.println("�䤣��R�O"+state);
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
			System.out.println("�䤣���ݩ� "+target);
		
	}
	public void changeDisplay(int x,String target)
	{
		System.out.println((DisplayInformation&(1<<x))+" "+(1<<x));
		if((DisplayInformation&(1<<x))==(1<<x))
		{
			DisplayInformation-=(1<<x);
			System.out.println("��������ݩ� "+target);
		}
		else
		{
			DisplayInformation+=(1<<x);
			System.out.println("�}������ݩ� "+target);
		}
	}
	public void setDirection()
	{
		list.setDirection();
	} 
}