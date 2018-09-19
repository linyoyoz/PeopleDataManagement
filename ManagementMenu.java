public class ManagementMenu extends Menu
{
	ManagementMenu()
	{
		
	}
	public void output()
	{
		System.out.println("管理模式選單");
		System.out.println("請輸入指令:");
		System.out.println("要變更資料設定請輸入:set");
		System.out.println("set的指令參數:");
		System.out.println("name 改變是否顯示name屬性");
		System.out.println("birthday 改變是否顯示birthday屬性");
		System.out.println("phone 改變是否顯示phone屬性");
		System.out.println("email 改變是否顯示email屬性");
		System.out.println("direction 改變資料排列的順序");
		System.out.println("要變更資料檔案請輸入:write");
		System.out.println("要上一頁請輸入:back");
	}
}