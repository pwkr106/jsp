package sub3;

public class InheritTest {
	public static void main(String[] args) {
		
		Computer com = new Computer("3.2GHz", "16G", 100);
		com.booting();
		com.calc();
		com.info();

		SmartPhone iphone = new SmartPhone("A10", "16G", 100 , "아이폰", "010-1234-1111");
		SmartPhone Gallaxy = new SmartPhone("2.6GHz", "16G", 100 , "갤럭시", "010-1234-2222");
		

		iphone.booting();
		iphone.calc(1);
		iphone.info();
		iphone.call();
		
		Gallaxy.booting();
		Gallaxy.calc(1);
		Gallaxy.info();
		Gallaxy.call();
		
		
	}
}