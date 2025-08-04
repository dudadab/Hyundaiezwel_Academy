package genericCollection.sec09;

import java.util.List;
import java.util.Vector;

public class VectorBoardMain {

    public static void main(String[] args) {
        // List interface 통해서 Vector 참조
        List<Board> list = new Vector<Board>();
        // Vector는 ArrayList와 내부 구조 동일 - 사용법 동일
        // 단, 쓰레드를 활용하는 경우 동기화 진행을 따로 하지 않아도 됨
        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));
        list.add(new Board("제목6", "내용6", "글쓴이6"));

        list.remove(2);
        list.remove(3);

        for(int i=0; i<list.size(); i++){
            Board board = list.get(i);
            System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
        }
    }
}
