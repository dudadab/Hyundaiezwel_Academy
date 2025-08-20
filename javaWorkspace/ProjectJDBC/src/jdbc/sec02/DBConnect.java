package jdbc.sec02;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	// 데이터베이스 연결 후
	// connection 객체를 반환하는 메서드
	public Connection getConnection() {
		Connection con = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user ="C##USER_SELECT";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd);
			
			if(con != null) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
