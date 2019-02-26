package sub1;

public class ClassTest {
	public static void main(String[] args) {
		
		int 	var1 = 1;
		boolean var2 = true;
		double 	var3 = 1.23;
		
		Account kb = new Account("±¹¹ÎÀºÇà", "123-12-1111", "È«±æµ¿", 10000);
		Account sh = new Account("½ÅÇÑÀºÇà", "123-12-2222", "±èÀ¯½Å", 50000);

		kb.deposit(10000);
		kb.withdraw(5000);
		kb.show();
		
		sh.deposit(35000);
		sh.withdraw(7000);
		sh.show();
		
	}
}
