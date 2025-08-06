package game_project.game;
import java.util.Random;
import java.util.Scanner;

public class Guess implements Game{

    @Override
    public void play(){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int comNumber = rand.nextInt(100) + 1;
        int userNumber = 0;
        int count = 0; // 시도 횟수

        System.out.println("----- 숫자 맞추기 게임 -----");
        System.out.println("1~100까지의 숫자 중 하나 입니다.");

        while(true){
            System.out.print("숫자 입력 : ");
            try{ // 숫자인지, 1~100 범위인지  예외처리
                userNumber = scan.nextInt();
                count++;
            } catch (Exception e){
                System.out.print("숫자만 입력해주세요.");
                scan.next();
                continue;
            }
            if(userNumber < 1 || userNumber > 100){
                System.out.print("1과 100 사이의 숫자를 입력해주세요.");
                continue;
            }
            if(userNumber < comNumber){
                System.out.println("UP!");
            }else if(userNumber > comNumber){
                System.out.println("DOWN!");
            }else{
                System.out.println("정답입니다!" + count + "번 만에 맞혔습니다.");
                break;
            }

        }
    }
}
