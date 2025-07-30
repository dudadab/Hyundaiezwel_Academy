package oopInheritance.sec07;

public class Automobile extends Car {
	String autoManual;
	
	public Automobile (String carNo, String carName, String carMaker, int carYear, String autoManual) {
		super(carNo, carName, carMaker,carYear);
		this.autoManual = autoManual;
	}
	@Override
	public String toString() {
		return "차량 번호 : " + carNo + "\n" 
				+ "차종 : " + carName + "\n"
				+ "제조사 : " + carMaker + "\n"
				+ "연식 : " + carYear + "\n"
				+ "기어변속 : " + autoManual;
	}
}
