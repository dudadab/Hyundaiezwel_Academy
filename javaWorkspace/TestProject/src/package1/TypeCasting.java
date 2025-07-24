package package1;

public class TypeCasting {

	public static void main(String[] args) {
		// 타입변환
		// 데이터 타입을 다른 타입으로 변환하는 것
		// 묵시적(자동) 타입 변환 : Promotion, 명시적(강제) 타입변환 : Casting
		// 타입변환은 변수의 타입이 저장하고자하는 리터럴 크기보다 크거나 작을 때
		
		// 자동 타입 변환 : 작은 크기 타입이 큰 크기 타입으로 저장될 때 
		// long형을 float형에 저장할 수 있나? 8byte -> 4byte 저장
		// byte 크기가 아닌 값의 표현 범위에 따라 규정
		// byte < short < int < long < float < double
		
		// 자동타입변환
		byte byteVal = 10;
		int intVal = byteVal; //모두 정수타입 int가 더 큰 범위 - 자동형변환 발생 
		System.out.println(intVal);
		
		char chrVal = '가';
		intVal = chrVal; // 2byte 크기의 값이 4byte 변수에 저장
		System.out.println(intVal); // '가'의 유니코드 값 44032
		
		long lngVal = 258960; // 8byte
		float flVal = lngVal; // 4byte - 값의 표현 범위는 float이 범위가 넓음 자동형변환 가능
		System.out.println(flVal);
		
		// 강제 타입 변환 - 데이터 손실이 발생함 (주의해서 변환되어야 함)
		//intVal = flVal; // float형의 표현범위가 int형보다 크므로 큰 범위의 표현이 작은 범위로 -> 대입 불가능
		flVal = 25.369847f;
		intVal = (int)flVal; // (int)리터럴 또는 변수 -> int형으로 강제 타입변환 발생
		System.out.println(intVal);
		
		intVal = 1030297770;
		byte byteValue = (byte)intVal; //정수를 정수타입에 저장 -> 큰 타입을 작은 타입에
		System.out.println(byteVal);
		
		intVal = 44032;
		chrVal = (char)intVal;
		System.out.println(chrVal);
		
		// 강제 타입 변환 시 주의
		// 값의 손실 발생 타입 범위 확인해서 형변환 결정
		// 기본타입에 대해서 자바는 객체로 구성해 놓았음
		// 기본타입객체.MIN_VALUE / 기본타입객체.MAX_VALUE
		// ex. Byte.MIN_VALUE, Int.MAX_VALUE
		// 정밀도 손실 발생 가능
		// float의 가수 23bit보다 큰 int값을 float으로 변환할때 손실 발생  => int를 실수로 변경 double형으로 변환
		
		// 연산식에서 자동 타입 변환
		int intVal1 = 10;
		double doubleVal1 = 5.5;
		
		double result = intVal1 + doubleVal1; //정수 + 실수 -> 정수를 실수로 형변환 후 연산진행
		
		int intVal4 = intVal1 / 4; //  정수/정수 => 정수
		intVal4 = (int)result;
		
		
		System.out.println(intVal4);
		System.out.println(intVal1/4.0); //  정수/실수 => 실수
		intVal4 = (int)(intVal1/4.0); // 연산결과가 double이므로 int형으로 자동형변환 불가능 -> 강제타입변환
		// 데이터 손실 발생
		System.out.println(intVal4);
	}

}
