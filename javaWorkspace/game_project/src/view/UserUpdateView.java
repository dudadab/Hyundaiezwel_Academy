package view;

import java.util.Scanner;
import user.UserDAO;
import user.UserDAOImpl;
import user.UserDTO;

public class UserUpdateView {
	
	private Scanner scan = new Scanner(System.in);
	private UserDAO userDAO;
	
	public UserUpdateView() {
		this.userDAO = new UserDAOImpl();
	}
	
	public void update(UserDTO loggedInUser) {
		System.out.println("---회원 정보 수정---");
		System.out.print("새 비밀번호: ");
		String newPass = scan.next();
		System.out.print("새 이름: ");
		String newName = scan.next();
		
		loggedInUser.setPass(newPass);
		loggedInUser.setName(newName);
		
		if (userDAO.updateUser(loggedInUser)) {
            System.out.println("회원 정보가 성공적으로 수정되었습니다.");
        } else {
            System.out.println("회원 정보 수정 실패.");
        }
	}
}
