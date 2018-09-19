import java.util.*;
import java.io.*;
public class DataList
{
	int number;
	private Data root,end,ptr;
	private OpenFile openfile;
	private Scanner s;
	private PrintWriter o;
	private boolean SortDirection;
	
	DataList()
	{
		SortDirection = true;
		number=0;
		root=null;
		end=null;
		openfile= new OpenFile();
		s=openfile.getScanner();
		build();
	}
	void build()
	{
		while(s.hasNext())
		{
			inputData(0,null);
		}
		s.close();
	}
	void write(String s)
	{
		sort(s);
		write();
	}
	void write()
	{
		try
		{
			o = new PrintWriter(new FileOutputStream("001.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
			System.exit(0);
		}
		for(ptr=root;ptr!=null;ptr=ptr.getNext())
		{
			o.print(ptr.getName()+" ");
			o.printf("%04d ",ptr.getBirthday());
			o.printf("%010d ",ptr.getPhone());
			o.print(ptr.getEmail()+" ");
			o.println(ptr.getCategory());
		}
		System.out.println("�g�J�ɮ�");
		o.close();
	}
	//�إ߷s����Data
	void CreatData(int d,String n,int b,int p,String e,String c)
	{
		ptr= new Data(d,n,b,p,e,c);

		if(end==null)
			root=ptr;
		else
			end.setNext(ptr);
		end = ptr;
		number++;
	}
	public boolean checkName(String name,Data modifyData)
	{
		ptr = Search(name);
		if(ptr!=null&&ptr!=modifyData)
		{
			System.out.println("���ƪ��W�r�R�W!");
			return false;
		}
		else
			return true;
	}
	public boolean checkBirthday(int birthday)
	{
		int month = birthday/100;
		int day = birthday%100;
		switch(month)
		{
			case 1: return day<=31&&day>=1;
			case 2:	return day<=29&&day>=1;
			case 3:	return day<=31&&day>=1;
			case 4:	return day<=30&&day>=1;
			case 5:	return day<=31&&day>=1;
			case 6:	return day<=30&&day>=1;
			case 7:	return day<=31&&day>=1;
			case 8:	return day<=31&&day>=1;
			case 9:	return day<=30&&day>=1;
			case 10:return day<=31&&day>=1;
			case 11:return day<=30&&day>=1;
			case 12:return day<=31&&day>=1;
			default: return false;
		}
	}
	public boolean checkPhone(int phone,Data modifyData)
	{
		ptr = Search(phone);
		if(ptr!=null&&ptr!=modifyData)
		{
			System.out.println("���ƪ��q�ܸ��X!");
			return false;
		}
		else
			return true;
	}
	public boolean checkEmail(String email)
	{
		int ok=0;
		for(int i=0;i<email.length();i++)
		{
			if(email.charAt(i)=='@')
			{
				return true;
			}	
		}
		return false;
	}
	public int checkInputType()
	{
		int test;
		try
		{
			test = s.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("���~����J���i��J�Ʀr�H�~���r��");
			return -1;	
		}
		return test;
	}
	public void inputData(int command,Data modifyData)
	{
		inputRemind(command,"Name");
		String name = s.next();
		if(!checkName(name,modifyData))
			return;

		inputRemind(command,"Birthday");
		int birthday = checkInputType();
		if(!checkBirthday(birthday))
		{
			System.out.println("���~���ͤ���");
			return;
		}
		
		inputRemind(command,"Phone Number");
		int phone = checkInputType();
		if(!checkPhone(phone,modifyData))
			return;

		inputRemind(command,"Email");
		String email = s.next();
		if(!checkEmail(email))
		{
			System.out.println("���~��email�榡");
			return;
		}
		inputRemind(command,"Catrgory");
		String category = s.next();
		if(modifyData==null)
			CreatData(1,name,birthday,phone,email,category);
		else
			modifyData.setAll(1,name,birthday,phone,email,category);
	}
	public void inputRemind(int command,String typeName)
	{
		//creat
		if(command == 1)
		{
			System.out.println("�п�J�n�s�W������ݩ� "+typeName+" �����e");
		}
		else if(command==2)
		{
			System.out.println("�п�J�n�ק諸����ݩ� "+typeName+" �����e");
		}
	}
	void Display()
	{
		for(ptr = root ;ptr!=null;ptr=ptr.getNext())
		{
			ptr.Display(15);
		}
	}
	//c����ܪ����
	void Display(int c)
	{
		int num=1;
		System.out.println(c);
		for(ptr = root ;ptr!=null;ptr=ptr.getNext())
		{
			if(num%10==1)
			{
				System.out.println();
				System.out.println();
				System.out.println("�Ǹ�   �m�W    �ͤ�   �q�ܸ��X     �q�l�H�c                           ����");	
			}
			System.out.printf("%03d.   ",num);
			num++;
			ptr.Display(c);
		}
	}
	//�Hs���зǶi��sort �åBc����ܪ����
	void Display(String s,int c)
	{
		if(checkSort(s))
		{
			sort(s);
			Display(c);
		}
		else
		{
			System.out.println("�S��"+s+"�o���ݩʭȥi�H�i��ƦC");
		}
	}
	//�u��������cate���~�n�Q���
	void Display(int c,String cate)
	{
		//�ΨӽT�{ cate �O�_���b��Ƹ�
		boolean ok=false;
		int num=1;
		for(ptr=root;ptr!=null;ptr=ptr.getNext())
		{
			
			if(ptr.getCategory().equals(cate))
			{
				if(num%10==1)
				{
					System.out.println();
					System.out.println();
					System.out.println("�Ǹ�   �m�W    �ͤ�   �q�ܸ��X     �q�l�H�c                           ����");	
				}
				System.out.printf("%03d.   ",num);
				num++;
				ptr.Display(c);
				ok = true;
			}
		}
		if(!ok)
			System.out.println("�S��"+cate+"�o�Ӥ����b��Ƥ�");
	}
	void Display(String s,int c,String cate)
	{
		if(checkSort(s))
		{
			sort(s);
			Display(c,cate);
		}
		else
		{
			System.out.println("�S��"+s+"�o���ݩʭȥi�H�i��ƦC");
		}
	}
	//��w�ƧǪk
	void sort(String s)
	{
		Data x,child,father=null;
		for(x=root;x!=null;x=x.getNext())
		{
			for(ptr=root;ptr!=null&&ptr.getNext()!=null;ptr=ptr.getNext())
			{
				if(cmp(ptr,ptr.getNext(),s))
				{
					child=ptr.getNext();
					//��root�Optr���ɭԦ]���Mchild�洫�ҥHroot�ܦ�child
					if(ptr==root)
						root=child;
					//��end�Ochild���ɭԦ]���Mptr�洫�ҥHend�ܦ�ptr
					if(child == end)
						end = ptr;
					//System.out.println(ptr.getName()+" "+child.getName());
					
					//�T�ӳs���n��
					//ptr �� next �|�Ochild��next
					ptr.setNext(child.getNext());
					
					//child ��next �|�O ptr
					child.setNext(ptr);
					
					//father �� next �|���� child
					if(father!=null)
						father.setNext(child);
				}
				father = ptr;
			}
			father = null;
		}
	}
	//�T�{�n�ƨ̷ӱƧǪ��ݩʬO�_���b��Ƹ�
	boolean checkSort(String s)
	{
		if(s.equals("name"))
			return true;
		else if(s.equals("birthday"))
			return true;
		else if(s.equals("phone"))
			return true;
		else if(s.equals("email"))
			return true;
		else
			return false;
	}
	//���ƪ�������
	boolean cmp(Data a,Data b,String s)
	{
		if(s.equals("name"))
		{
			if(SortDirection)
				return a.getName().compareTo(b.getName())>0;
			else
				return a.getName().compareTo(b.getName())<0;
		}
		else if(s.equals("birthday"))
		{
			if(SortDirection)
				return a.getBirthday()>b.getBirthday();
			else
				return a.getBirthday()<b.getBirthday();
		}
		else if(s.equals("phone"))
		{
			if(SortDirection)
				return a.getPhone()>b.getPhone();
			else
				return a.getPhone()<b.getPhone();
		}
		else if(s.equals("email"))
		{
			if(SortDirection)
				return a.getEmail().compareTo(b.getEmail())>0;
			else
				return a.getEmail().compareTo(b.getEmail())<0;
		}
		else
		{
			return false;
		}
	}
	//���J�s�����
	void Insert()
	{
		s = new Scanner(System.in);
		inputData(1,null);
	}
	//�j�M�q�ܸ��X
	public Data Search(int p)
	{
		for(ptr=root;ptr!=null;ptr=ptr.getNext())
		{
			if(ptr.getPhone()==p)
			{
				ptr.Display(15);
				return ptr;
			}
		}
		return null;
	}
	//�j�M�W�r
	public Data Search(String n)
	{
		for(ptr=root;ptr!=null;ptr=ptr.getNext())
		{
			if(ptr.getName().equals(n))
			{
				ptr.Display(15);
				return ptr;
			}
		}
		return null;
	}
	public void Delete(String n)
	{
		if(number==0)
		{
			System.out.printf("��ƬO�Ū�\n");	
		}
		Data father=null,child=null;
		for(ptr=root;ptr!=null;ptr=ptr.getNext())
		{
			if(ptr.getName().equals(n))
			{
				number--;
				if(ptr==root)
					root=ptr.getNext();
				if(ptr==end)
					end = father;
				if(father!=null)
				{
					father.setNext(ptr.getNext());
				}	
				System.out.println("�R����Ƥ��e:");
				ptr.Display(15);
				return;
			}
			father = ptr;
		}
		System.out.println("��Ƥ��S���W�r"+n);
	}
	public void Delete(int p)
	{
		if(number==0)
		{
			System.out.printf("��ƬO�Ū�\n");	
		}
		Data father=null,child=null;
		for(ptr=root;ptr!=null;ptr=ptr.getNext())
		{
			if(ptr.getPhone()==p)
			{
				number--;
				if(ptr==root)
					root=ptr.getNext();
				if(ptr==end)
					end = father;
				if(father!=null)
				{
					father.setNext(ptr.getNext());
				}	
				System.out.println("�R����Ƥ��e:");
				ptr.Display(15);
				return;
			}
			father = ptr;
		}
		System.out.printf("��Ƥ��S���q�ܸ��X%09d\n",p);
	}
	public void Modify(String target,String target2)
	{
		ptr=null;
		if(target.equals("name"))
		{
			System.out.printf("�n�ק諸��Ƥ��e:\n");
			ptr = Search(target2);
		}
		else if(target.equals("phone"))
		{
			System.out.printf("�n�ק諸��Ƥ��e:\n");
			ptr = Search(Integer.parseInt(target2));
		}
		else
		{
			System.out.printf("�ݩʭ�%s�L��\n",target);
			return;
		}
		if(ptr==null)
		{
			System.out.printf("�b��Ƥ��䤣�줺�e��%s\n",target2);
			return;
		}
		else
		{
			s=new Scanner(System.in);
			inputData(2,ptr);
		}
	}
	public void setDirection()
	{
		if(SortDirection)
		{
			System.out.println("��ƶ��ǧאּ�Ѥp��j");
			SortDirection = false;
		}
		else
		{
			System.out.println("��ƶ��ǧאּ�Ѥj��p");
			SortDirection = true;
		}
	} 
}