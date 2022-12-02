package Kotlin;

public class chap12JavaObject {
}

class JavaPerson1{
    private static final int MIN_AGE = 1;

    public static JavaPerson1 newBaby(String name) {
        return new JavaPerson1(name, MIN_AGE);
    }

    private String name;
    private  int age;

    private JavaPerson1(String name, int age){
        this.name = name;
        this.age =age;
    }

//Java에서의 Kotlin에 있는 static field나 static함수를 사용하고싶을때

    public static void main(String args[]){
        //이름이 companion object에 없는경우
        Person2.Companion.newBaby("ABC");
        //companion object내의 함수에 @JvmStatic이라는 Annotation을 붙여줬을때
        Person2.newBaby1("ABC"); //Companion을 생략하고 바로사용이 가능하다

        //companion object의 이름이 있는경우
        Person1.Factory.newBaby("ABC");
        Person1.newBaby1("ABC");

    }
}

class JavaSingleton{
    /*
    싱글톤이란 단하나의 인스턴스만을 갖는 클래스
    다음과 같이 static 영역에 인스턴스라는 것을 만들어서
    하나만을 가져오게하는 방법
     */

    private static final JavaSingleton INSTANCE = new JavaSingleton();

    private JavaSingleton(){};

    public static JavaSingleton getInstance(){
        return INSTANCE;
    }

}

//익명클래스
interface Movable{
    void move();
    void fly();
}

class unknown{
    public static void main(String[] args){
        moveSomething(new Movable() {
            @Override
            public void move() {
                System.out.println("움직인다~");
            }

            @Override
            public void fly() {
                System.out.println("난다~~");
            }
        });
    }

    private static void moveSomething(Movable movable){
        movable.move();
        movable.fly();
    }
}



