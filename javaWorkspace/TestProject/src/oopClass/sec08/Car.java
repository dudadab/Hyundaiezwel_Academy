package oopClass.sec08;

public class Car {
	//멤버변수, 데이터
	private String carNo; // 차량번호
	private String carName; // 차종
	private String carMaker; // 제조사
	private int carYear; // 연식
	private int carCC; // 배기량
	
	// 생성자 오버로딩 (동일한 생성자를 여러개 만든 것)
	// 매개변수가 없는 생성자
	public Car() {
		
	}
	
	// 매개변수가 있는 생성자 - 생성자 메서드 private 필드를 초깋
	public Car(String carNo, String carName, String carMaker) {
		// 멤버 필드와 매개변수명이 동일
		this.carNo=carNo;
		this.carName=carName;
		this.carMaker=carMaker;

	}
	
	public void setCarInfo(String no, String name, String maker, int carYear, int carCC) {
		carNo=no; // private 멤버변수 : 클래스 내부에서는 접근 가능
		carName=name;
		carMaker=maker;
		this.carYear=carYear;
		this.carCC=carCC;
	}
	
	public void showCarInfo() {
		System.out.println("차량번호 : " + carNo);
		System.out.println("차종 : " + carName);
		System.out.println("제조사 : " + carMaker);
		System.out.println("연식 : " + carYear);
		System.out.println("배기량 : " + carCC);
		
	}
	
}
