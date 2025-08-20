package user;
import java.util.Objects;

// 사용자 정보 보관
public class UserDTO {
    private String id;
    private String pass;
    private String name;

    public UserDTO(String id, String pass, String name){
        this.id = id;
        this.pass = pass;
        this.name = name;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
    public String getName() { return name; }
    public void setName(String name ) { this.name = name; }

    @Override
    public String toString(){
        return "User [ID= " + id + ", Name= " + name + "]";
    }

    // id와 name이 같으면 동일 유저로 판단
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }
}
