package Kotlin;

public class chap16JavaPersonExpandPerson{
    private final String firstName;
    private int age;

    public chap16JavaPersonExpandPerson(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public int nextYearAge(){
        System.out.println("멤버함수");
        return this.age +1 ;
    }

    public int getAge(){
        return age;
    }



//Java에서 Kotlin 확장함수를 가져다 사용하는법
public static void main(String[] args){
    chap16KotlinFunction t = new chap16KotlinFunction();
    System.out.println(t.lastChar1("ABC"));

    //chap16KotlinFunction.lastChar1("ABC");
}
}