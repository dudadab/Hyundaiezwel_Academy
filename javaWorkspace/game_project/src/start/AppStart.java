package start;
import java.util.Scanner;
import game.GaBaBo;
import info.AppInfo;
import game.Guess;
import user.UserDAO;
import user.UserDTO;
import user.UserDAOImpl;
import view.UserUpdateView;
import view.UserDeleteView;

public class AppStart {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AppInfo appInfo = new AppInfo();
        GaBaBo gaBaBo = new GaBaBo();
        Guess guess = new Guess();
        UserDAO userDAO = new UserDAOImpl();
        
        UserUpdateView userUpdateView = new UserUpdateView();
        UserDeleteView userDeleteView = new UserDeleteView();

        UserDTO loggedInUser = null; 
        
        while(true){
            System.out.println("---------- 종합 게임 시작 ----------");
            System.out.println("-------------- 메뉴 --------------");
            if (loggedInUser == null) {
                // 로그인 전 메뉴
                System.out.println("1. 회원가입");
                System.out.println("2. 로그인");
                System.out.println("3. 애플리케이션 정보");
                System.out.println("4. 종료");
            } else {
                // 로그인 후 메뉴
                System.out.println("--- " + loggedInUser.getName() + "님, 환영합니다! ---");
                System.out.println("1. 회원정보 수정"); 
                System.out.println("2. 회원 탈퇴");    
                System.out.println("3. 가위바위보 게임");
                System.out.println("4. 숫자 맞추기 게임");
                System.out.println("5. 로그아웃");   
                System.out.println("6. 애플리케이션 정보");
                System.out.println("7. 종료");
            }
            System.out.println("---------------------------------");
            System.out.print("메뉴 번호 입력 : ");

            String menu = scan.next();

            if(loggedInUser == null) {
            	switch(menu) {
            	case "1" -> {
                    System.out.println("--- 회원가입 ---");
                    System.out.print("아이디: ");
                    String id = scan.next();
                    System.out.print("비밀번호: ");
                    String pass = scan.next();
                    System.out.print("이름: ");
                    String name = scan.next();

                    UserDTO newUser = new UserDTO(id, pass, name);
                    if(userDAO.addUser(newUser)){
                        System.out.println("가입 성공!");
                    }else{
                        System.out.println("가입 실패, 이미 존재하는 회원입니다.");
                    }
                }
                case "2" -> {
                    System.out.println("--- 로그인 ---");
                    System.out.print("아이디: ");
                    String id = scan.next();
                    System.out.print("비밀번호: ");
                    String pass = scan.next();

                    loggedInUser = userDAO.login(id, pass);

                    if(loggedInUser != null){
                        System.out.println("로그인 성공! " + loggedInUser.getName() + "님, 환영합니다.");
                    } else{
                        System.out.println("로그인 실패");
                    }
                }
                case "3" -> appInfo.infoRun();
                case "4" -> {
                	System.out.println("종료합니다!");
                    scan.close();
                    return;
                }
                default -> System.out.println("메뉴 번호를 다시 입력해주세요.");
            }
          } else {
        	  switch(menu) {
        	  case "1" -> { 
        		  userUpdateView.update(loggedInUser);
                  break;
              }
              case "2" -> {
            	  boolean isDeleted = userDeleteView.delete(loggedInUser);
                  if (isDeleted) {
                      loggedInUser = null; 
                  }
                  break;
              }
              case "3" -> {System.out.println("가위바위보 게임을 시작합니다."); gaBaBo.play();}
              case "4" -> {System.out.println("숫자 맞추기 게임을 시작합니다."); guess.play();}
              case "5" -> {
                  System.out.println("로그아웃 되었습니다.");
                  loggedInUser = null; // 로그아웃 처리
              }
              case "6" -> {System.out.println("애플리케이션 정보를 표시합니다."); appInfo.infoRun();}
              case "7" -> {System.out.println("종료합니다!"); scan.close(); return;}
        	  default -> System.out.println("메뉴 번호를 다시 입력해주세요.");
          }
                    
            System.out.println();
        }
      }
    }
}
