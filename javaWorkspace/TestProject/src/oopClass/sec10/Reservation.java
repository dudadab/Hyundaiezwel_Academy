package oopClass.sec10;

public class Reservation {
	
	private String aircraft, name, origin, destination, seatNo;
	private int price;
	
	public Reservation() {
		this("KE1001", "홍길동", "인천", "뉴욕", 16000000, "A38");
	}
	
	public Reservation(String aircraft, String name, String origin, String destination, int price, String seatNo) {
		this.aircraft = aircraft;
		this.name = name;
		this.origin = origin;
		this.destination = destination;
		this.price = price;
		this.seatNo = seatNo;
	}
	
	public void showRsvInfo() {
		System.out.println("**항공권 예약 정보**");
		System.out.println("항공기 : " + aircraft);
		System.out.println("예약자 : " + name);
		System.out.println("출발지 : " + origin);
		System.out.println("도착지 : " + destination);
		System.out.println("금액 : " + price);
		System.out.println("좌석번호 : " + seatNo);
	}
}
