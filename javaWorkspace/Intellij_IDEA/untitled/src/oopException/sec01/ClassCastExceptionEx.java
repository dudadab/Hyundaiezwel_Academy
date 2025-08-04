package oopException.sec01;

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}

public class ClassCastExceptionEx {

    public static void main(String[] args) {
        // 사용자 정의 클래스에 대해 강제 형변환 연산을 진행할 때
        Dog dog = new Dog();
        changeDog(dog); // Dog 객체 참조 인수로 전달 -> 자동형변환 발생 Animal 타입으로 변경 -> Dog 타입으로 강제 변환 가능

        Cat cat = new Cat();
        changeDog(cat); // Cat 객체 참조 인수로 전달 -> 자동형변환 발생 Animal 타입으로 변경 -> Dog 타입에 기인한 Animal이 아니므로
                        // 강제 변환 에러 발생 Cat cannot be cast to class
    }

    public static void changeDog(Animal animal){
        Dog dog = (Dog)animal;
    }
}


