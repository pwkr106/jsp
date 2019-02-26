package sub3;

public class Computer {

	private String cpu;
	private String ram;
	private int price;
	
	public Computer(String cpu, String ram, int price) {
		this.cpu = cpu;
		this.ram = ram;
		this.price = price;
	}
	
	public void calc() {
		System.out.println("계산중...");
	}
	
	public void booting() {
		System.out.println("부팅중...");
	}
	
	public void info() {
		System.out.println("================");
		System.out.println("CPU : "+cpu);
		System.out.println("RAM : "+ram);
		System.out.println("가격 : "+price);
		System.out.println("----------------");
	}
	
}