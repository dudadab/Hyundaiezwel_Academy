package genericCollection.sec07;

import java.util.ArrayList;
import java.util.Iterator;
public class EmployeeMain {

    public static void main(String[] args) {
        // 사용자 정의 클래스 타입

        ArrayList<Employee> list = new ArrayList<Employee>();

        Employee e1 = new Employee(100, "Mark", 3000);
        Employee e2 = new Employee(101, "James", 4000);

        list.add(e1);
        list.add(e2);
        list.add(new Employee(102,"John",7000));

        for(int i=0; i<list.size(); i++){
            Employee emp = list.get(i);
            System.out.println(emp);
        }

        for(Employee emp : list){
            System.out.println(emp);
        }

        System.out.println();
        // Iterator 사용해서 출력
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
