package sub1;

public class Account {
	
	//
	private String bank;
	private String id;
	private String name;
	private int money;
	

	public Account(String bank, String id, String name, int money) {
		this.bank = bank;
		this.id = id;
		this.name = name;
		this.money = money;
	}

	//
	public void deposit(int money) {
		this.money += money;
	}
	
	public void withdraw(int money) {
		this.money -= money;
	}
	
	public void show() {
		System.out.println("====================");
		System.out.println("은 행 명"+bank);
		System.out.println("계좌번호"+id);
		System.out.println("입 금 주"+name);
		System.out.println("현재잔액"+money);
		System.out.println("--------------------");
		
	}
	
}
