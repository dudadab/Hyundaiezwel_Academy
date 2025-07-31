package oopInheritance.sec08;

public class Worker {
	private String joominNo;
	private String name;
	
	public Worker(String joominNo, String name) {
		this.joominNo = joominNo;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + "\n주민번호 : " + joominNo;
	}
}
