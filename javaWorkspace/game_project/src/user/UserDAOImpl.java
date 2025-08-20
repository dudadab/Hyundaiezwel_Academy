package user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import util.DBConnect;

public class UserDAOImpl implements UserDAO{
    // 사용자 정보를 저장할 Set
    // HashSet 중복 가입 방지
    private Set<UserDTO> users = new HashSet<>();

    // 새로운 유저 추가 true, false 반환
    @Override
    public boolean addUser(UserDTO user){
    	Connection con = null;
    	PreparedStatement pstmt = null;

    	try {
    	    con = DBConnect.getConnection(); // DB 연결
    	    String sql = "INSERT INTO USERS (USER_ID, USER_PASSWORD, USER_NAME) VALUES (?, ?, ?)";
    	    pstmt = con.prepareStatement(sql);
    	    pstmt.setString(1, user.getId());
    	    pstmt.setString(2, user.getPass());
    	    pstmt.setString(3, user.getName());

    	    int result = pstmt.executeUpdate();
    	    return result > 0;
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    return false; // 오류 발생 시 가입 실패
    	} finally {
    	    DBConnect.close(con, pstmt); // 자원 반환
    	}
   }

    // ID와 비밀번호로 유저를 찾아 로그인
    @Override
    public UserDTO login(String id, String pass){
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;

    	try {
    	    con = DBConnect.getConnection();
    	    String sql = "SELECT * FROM USERS WHERE USER_ID = ? AND USER_PASSWORD = ?";
    	    pstmt = con.prepareStatement(sql);
    	    pstmt.setString(1, id);
    	    pstmt.setString(2, pass);

    	    rs = pstmt.executeQuery();
    	    if (rs.next()) {
    	        // 일치하는 사용자가 있으면 DTO 객체로 만들어 반환
    	        return new UserDTO(rs.getString("USER_ID"), rs.getString("USER_PASSWORD"), rs.getString("USER_NAME"));
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	} finally {
    	    DBConnect.close(con, pstmt, rs); // 자원 반환
    	}
    	return null; // 로그인 실패
    }
    
    @Override
    public boolean updateUser(UserDTO user) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DBConnect.getConnection();
            // SQL: USER_ID를 기준으로 USER_PASSWORD와 USER_NAME을 업데이트
            String sql = "UPDATE USERS SET USER_PASSWORD = ?, USER_NAME = ? WHERE USER_ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getPass());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getId());

            int result = pstmt.executeUpdate();
            return result > 0; // 업데이트된 행이 있으면 true 반환
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnect.close(con, pstmt, null); // 자원 반환
        }
    }
    
    @Override
    public boolean deleteUser(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DBConnect.getConnection();
            String sql = "DELETE FROM USERS WHERE USER_ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);

            int result = pstmt.executeUpdate();
            return result > 0; // 삭제된 행이 1개 이상이면 true 반환
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnect.close(con, pstmt, null);
        }
    }
}
