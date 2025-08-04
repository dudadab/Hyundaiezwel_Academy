package genericCollection.sec14;
import java.util.Objects;

public class Student {
    // Map 콜렉션에 저장될 데이터의 key로 사용할 클래스
    private int stdNo;
    private String stdName;

    public Student(int stdNo,String stdName){
        this.stdNo = stdNo;
        this.stdName = stdName;
    }

    public int getStdNo() {
        return stdNo;
    }
    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }
    public String getStdName() {
        return stdName;
    }
    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stdNo == student.stdNo && Objects.equals(stdName, student.stdName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stdNo, stdName);
    }
}
