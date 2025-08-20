package user;

public interface UserDAO {
    // 회원가입 기능 정의
    boolean addUser(UserDTO user);
    // 로그인 기능 정의
    UserDTO login(String id, String pass);
    // 회원정보 수정 기능 정의
    boolean updateUser(UserDTO user);
    // 회원 탈퇴 기능 정의
    boolean deleteUser(String id);
}
