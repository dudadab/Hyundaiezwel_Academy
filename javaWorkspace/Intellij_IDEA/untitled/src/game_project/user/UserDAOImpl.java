package game_project.user;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl implements UserDAO{
    // 사용자 정보를 저장할 Set
    // HashSet 중복 가입 방지
    private Set<UserDTO> users = new HashSet<>();

    // 새로운 유저 추가 true, false 반환
    @Override
    public boolean addUser(UserDTO user){
        return users.add(user);
    }

    // ID와 비밀번호로 유저를 찾아 로그인
    @Override
    public UserDTO login(String id, String pass){
        for(UserDTO user : users){
            if(user.getId().equals(id)){
                if(user.getPass().equals(pass)){
                    return user;
                }
            }
        }
        return null;
    }
}
