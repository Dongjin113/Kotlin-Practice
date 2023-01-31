package Kotlin;

public class Chap9JavaClass {

    //final 한번 정해진후 다시 바꿀수 없는 불변 filed의 값을 설정해줄수 없기떄문에 에러가난다
    //name을 초기화 할 수 없어 에러가난다 생성자를 만들어주면 에러가 나지않는다
    private final String name;
    private int age;

    public Chap9JavaClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //name은 불변의 값이기때문에 setter를 받을 수 없다 getter는 가능하다
    /*

    public

    public String getName() {
        return name;
    }
 */

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdult(){
        return this.age >=20;
    }
}
