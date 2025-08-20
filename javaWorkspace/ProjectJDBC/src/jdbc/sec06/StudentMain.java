package jdbc.sec06;

import java.util.Scanner;
import java.util.ArrayList;

public class StudentMain {

	public static void main(String[] args) {
		// DAO 기능 확인
		// 필요 객체 생성 및 변수 선언
		StudentDAO dao = new StudentDAO(); // 객체 생성 시 자동으로 DB 연결
		Scanner sc = new Scanner(System.in);
		ArrayList<StudentDTO> stdList = null;
		String stdNo;
		String dptNo;

		try {
			// 1. 학생 정보 입력
			// DAO 클래스의 insertStudent(StudentDTO) 호출
			dao.insertStudent(ReadWrite.getStdInfo(sc));
			
			// 2. 전체 학생 정보 조회
			// DAO 클래스의 getAllStudent()호출
			stdList = dao.getAllstudent();
			ReadWrite.writestdInfo(stdList);
			
			// 3. 학생 정보 수정(수정하려고 하는 학생의 개별정보를 출력)
			// 개별 정보 출력해주고
			System.out.println("학번을 입력하세요");
			stdNo = sc.nextLine();
			ReadWrite.writestdInfo(dao.detailStudent(stdNo));
			
			// 4. 학과번호를 통한 검색
			System.out.println("학과번호를 입력하세요");
			dptNo = sc.nextLine();
			ReadWrite.writestdInfo(dao.searchStudent(dptNo));
			
			// 5. 학생 정보 삭제
			System.out.println("학번을 입력하세요");
			stdNo = sc.nextLine();
			dao.deleteStudent(stdNo);
		}catch(Exception e) {
			System.out.println("test 중 오류 발생");
			e.printStackTrace();
		}
		sc.close();
	}

}
