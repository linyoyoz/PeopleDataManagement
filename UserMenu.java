public class UserMenu extends Menu
{
	UserMenu()
	{
	}
	public void output()
	{
		System.out.println("使用者模式選單");
		System.out.println("請輸入指令:");
		System.out.println("要顯示資料請輸入:list");
		System.out.println("lista為顯示所有資料");
		System.out.println("listc為顯示某分類資料");
		System.out.println("list 的參數:");
		System.out.println("name 改變以name屬性為排序依據");
		System.out.println("birthday 改變以birthday為排序依據");
		System.out.println("phone 改變以phone為排序依據");
		System.out.println("email 改變以email為排序依據");
		System.out.println("listc 的第二個參數請輸入想要顯示的分類");
		System.out.println("要新增資料請輸入:creat");
		System.out.println("要移除資料請輸入:delete 並帶參數搜尋該資料的屬性以及該屬性的內容");
		System.out.println("要修改資料請輸入:modify 並帶參數搜尋該資料的屬性以及該屬性的內容");
		System.out.println("要搜尋資料請輸入:search 並帶參數搜尋該資料的屬性以及該屬性的內容");
		System.out.println("要上一頁請輸入:back");
	}
}