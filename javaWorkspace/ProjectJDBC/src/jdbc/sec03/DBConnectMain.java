package jdbc.sec03;
import java.sql.Connection;
import java.sql.Statement; // db에 질의어를 전달하고 결과를 반환 받는 객체
import java.sql.ResultSet; // 반환결과가 릴레이션일 때 반환되는 결과를 저장하는 객체(select)
import java.sql.SQLException; // sql 질의에 해당하는 예외 
import java.sql.Date;

public class DBConnectMain {

	public static void main(String[] args) {
		// book 테이블의 data 조회
		// 필요 객체 생성
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection(); // db연결
		Statement stmt = null; // 질의 전달 결과 반환
		ResultSet rs = null; // 릴레이션 처리 객체
		
		// db와 통신 예외 처리 필요함
		try {
			// Statement 객체 인스턴스 반환 : Connection 인터페이스의 createStatement() 사용
			stmt = con.createStatement(); // sql 질의 진행 가능한 객체 반환
			// 쿼리 구문
			String sql = "select * from book order by bookno";
			
			// Statement 질의어 전달해서 실행 시키고 select 절 이므로 결과 받아옴
			// 전달한 질의가 select 구문이므로 릴레이션 반환되므로 ResultSet에 저장 
			// ResultSet.executeQuery(String) : 반환되는 결과가 릴레이션일 때 쿼리를 실행하는 메서드
			// select 등 릴레이션 반환하는 질의어일 때는 excuteQuery 사용
			rs = stmt.executeQuery(sql);
			
			// 반환 받음 결과 처리
			System.out.println("---------- 전체 도서 정보 조회 ----------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t  가격 \t\t 발행일  \t재고 \t출판사번호");
			// ResultSet 객체는 2차원 테이블로 구성됨
			// rs.next() : 현재 포인팅하는 튜플에서 다음 튜플로 포인터 이동, 다음 튜플이 있으면 true, 없으면 false
			// rs.getXXX(컬럼번호/컬럼명) : 현재 포인팅하는 튜플의 컬럼 값을 반환
			// XXX에는 컬럼의 타입을 씀 : getString(), getInt(), getDouble(), getDate()
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				// 한 행씩 출력
				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n",
									bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
			}
			// 사용객체 닫음 - 연 순서 반대로
			rs.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			System.out.println("오류발생");
			e.printStackTrace();
		}

	}

}
