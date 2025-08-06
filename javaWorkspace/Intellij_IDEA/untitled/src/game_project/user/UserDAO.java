package game_project.user;

public interface UserDAO {
    // 회원가입 기능 정의
    boolean addUser(UserDTO user);
    // 로그인 기능 정의
    UserDTO login(String id, String pass);

}
