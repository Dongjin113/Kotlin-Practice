import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Person {

    private final String name;
    private int age;

    public Person(String name , int age){
        //나이검증
        if(this.age <=0){
            throw new IllegalArgumentException(String.format("나이는 %s일 수 없습니다",age));
        }
        this.name = name;
        this.age = age;
    }

    public Person(String name ){
        //기존에 있던 생성자를 호출해준다
        this(name, 1);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //@Nullable
    //@NotNull
    public String getName(){
        return name;
    }
}

class Test{
    public static void main(String args[]) {
        /*
        //number 5 는 int number6은 Long
        int number5 = 4;
        long number6 = number5;
        System.out.println(number5 + number6);
        //int는 4byte long은 8byte로 long이 더크니까 들어간다음에 계산이된다
        //java에서는 int타입의 값이 long타입으로 암시적으로 변경이된다 그냥 넣었을뿐인데 큰타입으로 암시적으로 변경이된것


         */

        Person person = new Person("둘리");
        System.out.println((String.format("이름 : %s", person.getName())));

    }

    public static void printAgeIfPerson(Object obj){
        //instanceof 변수가 주어진타입이면 true 그렇지 않으면 false
        if(obj instanceof Person){
            Person person = (Person) obj;
            System.out.println(person.getName());
        }


        //Person 타입이 아니라면
        if(!(obj instanceof Person)){
            Person person = (Person) obj;
            System.out.println(person.getName());
        }
    }
}