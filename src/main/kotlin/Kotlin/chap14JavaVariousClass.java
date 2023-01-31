package Kotlin;

import java.util.Objects;

public class chap14JavaVariousClass {
}

//계층간의 데이터를 전달하기 위함 DTO(Data Transfer Object)
/*
    데이터 필드
    생성자, getter, equals, hashCode, toString
 */
class JavaPersonDto{

    private final String name;
    private final int age;

    public JavaPersonDto(String name, int age){
        this.name =name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaPersonDto that = (JavaPersonDto) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "JavaPersonDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    /*
    IDE를 활용할 수도 있고, lombok을 활용할 수도 있지만

    클래스가 장황해지거나, 클래스 생성 이후 추가적인 처리를 해줘야하는 단점이 있다.

     */
}

//Enum Class

enum JavaCountry{
    //두개의 Enum타입
    //Enum의 특징
    //추가적인 클래스를 상속받을 수 없다.
    //인터페이스는 구현할 수 있으며, 각 코드가 싱글톤이다.
    KOREA("KO"),
    AMERICA("US");

    private final String code;

    JavaCountry(String code) {this.code = code;}

    public String getCode() {return code;}

    private static void handleCountry(JavaCountry country){
        if(country == JavaCountry.KOREA){

        }

        if(country == JavaCountry.AMERICA){

        }
    }
}