package game_project.game;
import java.util.Random;
import java.util.Scanner;

public class GaBaBo implements Game{
    @Override
    public void play(){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String[] choices = {"가위", "바위", "보"}; // 컴퓨터가 낼 선택지

        while(true){
            System.out.println("----- 가위바위보 게임 -----");
            System.out.print("1. 가위, 2. 바위, 3. 보 \n선택 : ");

            int userChoice;
            try{ // 숫자인지, 1~3 범위인지 예외처리
                userChoice = scan.nextInt();
                if(userChoice < 1 || userChoice >3){
                    System.out.print("1, 2, 3 중에서 다시 입력해주세요.");
                    continue;
                }
            } catch(Exception e){
                System.out.print("숫자로 입력해주세요.");
                scan.next();
                continue;
            }

            int comChoice = rand.nextInt(3) + 1;

            System.out.println("컴퓨터는 " + choices[comChoice -1] + "입니다.");

            // 게임 결과
            if(userChoice == comChoice){
                System.out.println("비겼습니다!");
            }else if((userChoice == 1 && comChoice == 3) ||
                     (userChoice == 2 && comChoice == 1) ||
                     (userChoice == 3 && comChoice == 2)){
                System.out.println("승리!");
            }else{
                System.out.println("패배");
            }
            System.out.print("계속하시겠습니까? (y/n): ");
            String continueChoice = scan.next();

            if(!continueChoice.equalsIgnoreCase("y")){
                System.out.println("게임을 종료합니다.");
                break;
            }
            System.out.println();
        }
    }
}
