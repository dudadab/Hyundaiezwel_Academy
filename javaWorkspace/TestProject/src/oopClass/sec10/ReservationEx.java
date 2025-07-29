package oopClass.sec10;

public class ReservationEx {

	public static void main(String[] args) {
		Reservation re = new Reservation();
		Reservation res = new Reservation("KE1101","이몽룡","제주","나리타",300000,"A12");

		re.showRsvInfo();
		res.showRsvInfo();
	}

}
