package view;

import java.util.Scanner;
import user.UserDAO;
import user.UserDAOImpl;
import user.UserDTO;

public class UserDeleteView {
	private Scanner scan = new Scanner(System.in);
	private UserDAO userDAO;
	
	public UserDeleteView() {
        this.userDAO = new UserDAOImpl();
    }
	
	public boolean delete(UserDTO loggedInUser) {
        System.out.println("--- 회원 탈퇴 ---");
        System.out.print("정말 탈퇴하시겠습니까? (y/n): ");
        String answer = scan.next();

        if (answer.equalsIgnoreCase("y")) {
            if (userDAO.deleteUser(loggedInUser.getId())) {
                System.out.println("회원 탈퇴가 완료되었습니다.");
                return true;
            } else {
                System.out.println("회원 탈퇴 실패.");
                return false;
            }
        } else {
            System.out.println("회원 탈퇴를 취소합니다.");
            return false;
        }
    }
}
