package ch05;

public class ClassTest {
	public static void main(String[] args) {
		
		int num = 10;
		
		Account kb = new Account("��������", "123-12-1111", "ȫ�浿", 10000);
		Account sh = new Account("��������", "123-12-2222", "������", 50000);

		kb.deposit(10000);
		kb.withdraw(5000);
		kb.show();
		
		sh.deposit(35000);
		sh.withdraw(7000);
		sh.show();
		
	}
}
